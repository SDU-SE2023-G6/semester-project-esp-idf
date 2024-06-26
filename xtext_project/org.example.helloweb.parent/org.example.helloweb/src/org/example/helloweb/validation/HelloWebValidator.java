/*
 * generated by Xtext 2.33.0
 */
package org.example.helloweb.validation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.example.helloweb.helloWeb.DeviceType;
import org.example.helloweb.helloWeb.HelloWebPackage;
import org.example.helloweb.helloWeb.Output;
import org.example.helloweb.helloWeb.Pin;
import org.example.helloweb.helloWeb.Sensor;
import org.example.helloweb.helloWeb.SensorConfig;
import org.example.helloweb.helloWeb.SensorInstantiation;
import org.example.helloweb.helloWeb.SensorUnit;
import org.example.helloweb.helloWeb.TimeUnit;
import org.example.helloweb.helloWeb.ValueRef;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class HelloWebValidator extends AbstractHelloWebValidator {


	private final static Map<String, ReaderMethodMetadata> readers = new HashMap<>();
	private final static Set<Integer> validPinNumbers = new HashSet<>(Set.of(
            36, 37, 38, 39, 32, 33, 34, 35, // ADC1 GPIOs
            4, 0, 2, 15, 13, 12, 14, 27, 25, 26 // ADC2 GPIOs
	));

	static {
		Arrays.asList(
				new ReaderMethodMetadata("dht11Reader", 2, 2),
				new ReaderMethodMetadata("lightResReader", 1, 1),
				new ReaderMethodMetadata("lmt86Reader", 1, 1)
		).forEach(reader -> readers.put(reader.name, reader));
	}
	public static class ReaderMethodMetadata {
		public final String name;
		public final int expectedPinCount;
		public final int expectedOutCount;
		public ReaderMethodMetadata(String name, int expectedPinCount, int expectedOutCount) {
			this.name = name;
			this.expectedPinCount = expectedPinCount;
			this.expectedOutCount = expectedOutCount;
		}
	}

	@Check(CheckType.FAST)
	public void checkUniqueSensorNames(SensorConfig config) {
		Set<String> names = new HashSet<>();
		for (Sensor sensor : config.getSensors()) {
			if (!names.add(sensor.getName())) {
				error("Duplicate sensor name: " + sensor.getName(),
						HelloWebPackage.Literals.SENSOR__NAME);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkUniqueSensorUnits(Sensor sensor) {
		Set<String> units = new HashSet<>();
		for (SensorUnit unit : sensor.getUnits()) {
			if (!units.add(unit.getValue())) {
				error("Duplicate unit: " + unit.getValue(),
						HelloWebPackage.Literals.SENSOR__UNITS);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkUniquePinNames(Sensor sensor) {
		Set<String> pinNames = new HashSet<>();
		for (Pin pin : sensor.getPins()) {
			if (!pinNames.add(pin.getName())) {
				error("Duplicate pin name: " + pin.getName(),
						HelloWebPackage.Literals.SENSOR__PINS);
			}
		}
	}


	@Check(CheckType.FAST)
	public void checkUniqueDeviceTypeNames(SensorConfig config) {
		Set<String> names = new HashSet<>();
		for (DeviceType deviceType : config.getDeviceTypes()) {
			if (!names.add(deviceType.getName())) {
				error("Duplicate device type name: " + deviceType.getName(),
						HelloWebPackage.Literals.DEVICE_TYPE__NAME);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkNonEmptyCollections(Sensor sensor) {
		if (sensor.getUnits().isEmpty()) {
			error("Units must not be empty",
					HelloWebPackage.Literals.SENSOR__UNITS);
		}
		if (sensor.getPins().isEmpty()) {
			error("Pins must not be empty",
					HelloWebPackage.Literals.SENSOR__PINS);
		}
		if (sensor.getOut().isEmpty()) {
			error("Output must not be empty",
					HelloWebPackage.Literals.SENSOR__OUT);
		}
	}

	@Check(CheckType.FAST)
	public void checkValidReaderReference(Sensor sensor) {
		if (!readers.containsKey(sensor.getReader())) {
			error("Invalid reader reference: " + sensor.getReader(),
					HelloWebPackage.Literals.SENSOR__READER);
		}
	}

	@Check(CheckType.FAST)
	public void checkValidReaderInput(Sensor sensor) {
		if (!readers.containsKey(sensor.getReader())) {
			return;

		}

		int expected = readers.get(sensor.getReader()).expectedPinCount;
		int found = sensor.getPins().size();
		if(expected != found) {
			error("Reader expected %d pins but %d was assigned".formatted(expected, found),
					HelloWebPackage.Literals.SENSOR__PINS);
		}
	}

	@Check(CheckType.FAST)
	public void checkValidReaderOutput(Sensor sensor) {
		if (!readers.containsKey(sensor.getReader())) {
			return;

		}

		int expected = readers.get(sensor.getReader()).expectedOutCount;
		int found = sensor.getOut().size();
		if(expected != found) {
			error("Reader expected %d outputs but %d was assigned".formatted(expected, found),
					HelloWebPackage.Literals.SENSOR__OUT);
		}
	}

	@Check(CheckType.FAST)
	public void sensorUnitsMustBeSameCountAsOut(Sensor sensor) {
		int expected = sensor.getOut().size();
		int found = sensor.getUnits().size();
		if(expected != found) {
			error("Sensor must have same number of units as outputs: expected %d but found %d".formatted(expected, found),
					HelloWebPackage.Literals.SENSOR__UNITS);
		}
	}

	@Check(CheckType.FAST)
	public void mustReferenceValidSensorAndOutput(ValueRef ref) {
		SensorInstantiation instantiation = findContainingSensorInstantiation(ref);

		if (instantiation == null) {
			error("References must be either local or within the scope of a SensorInstantiation",
					HelloWebPackage.Literals.VALUE_REF__OUT);
			return;
		}

		String referencedOutput = ref.getOut();
		EList<Output> expected = instantiation.getSensor().getOut();
		if (referencedOutput == null || !expected.stream().anyMatch(output -> output.getName().equals(referencedOutput))) {
			error("Output reference '%s'did not match any of the sensors expected references: %s: ".formatted(
							referencedOutput,
							expected.stream()
									.map(Output::getName)
									.collect(Collectors.joining(", "))

					),
					HelloWebPackage.Literals.VALUE_REF__OUT);
		}
	}


	private SensorInstantiation findContainingSensorInstantiation(ValueRef ref) {
		if(ref.getSensorInstantiation() != null) {
			return ref.getSensorInstantiation();
		}

		EObject container = ref.eContainer();
		while (container != null) {
			if (container instanceof SensorInstantiation) {
				return (SensorInstantiation) container;
			}
			container = container.eContainer();
		}
		return null;
	}

	@Check(CheckType.FAST)
	public void checkPinNumberConsistency(SensorInstantiation instantiation) {
		Sensor sensor = instantiation.getSensor();
		if (sensor != null) {
			if (instantiation.getPins().size() != sensor.getPins().size()) {
				error("Sensor expected %d pins but %d was configured".formatted(
								instantiation.getPins().size(),
								sensor.getPins().size()
						),
						HelloWebPackage.Literals.SENSOR_INSTANTIATION__PINS);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkValidSensorReference(SensorInstantiation instantiation) {
		if (instantiation.getSensor() == null) {
			error("Sensor reference must not be null",
					HelloWebPackage.Literals.SENSOR_INSTANTIATION__SENSOR);
		}
	}


	@Check(CheckType.FAST)
	public void checkValidTimeUnits(TimeUnit timeUnit) {
		if (timeUnit.getValue() <= 1) {
			error("Time value must be equal to or greater than 1",
					HelloWebPackage.Literals.TIME_UNIT__VALUE);
		}
	}

	@Check(CheckType.FAST)
	public void checkValidPinNumber(SensorInstantiation instantiation) {
		for (Integer pin : instantiation.getPins()) {
			if (!validPinNumbers.contains(pin)) {
				error("Invalid pin number: %s. Expected one of: %s".formatted(
								pin,
								validPinNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "))
						),
						HelloWebPackage.Literals.SENSOR_INSTANTIATION__PINS);
			}
		}
	}

	@Check(CheckType.FAST)
	public void uniquePinNumbers(SensorInstantiation sensorInstantiation) {
		Set<Integer> pins = new HashSet<>();
		// Find parent DeviceType container
		EObject container = sensorInstantiation.eContainer();
		// Query all sensor instantiations in device type
		if (container instanceof DeviceType) {
			DeviceType deviceTypeContainer = (DeviceType) container;
			for (SensorInstantiation instantiation : deviceTypeContainer.getSensorInstantiations()) {
				if (instantiation != sensorInstantiation) {
					for (Integer pin : instantiation.getPins()) {
						pins.add(pin);
					}
				}
			}
		}

		for (Integer pin : sensorInstantiation.getPins()) {
			if (!pins.add(pin)) {
				error("Duplicate pin number: %s".formatted(pin),
						HelloWebPackage.Literals.SENSOR_INSTANTIATION__PINS);
			}
		}
	}

	@Check(CheckType.FAST)
	public void batchSizePolicyMustBeGreaterThanZero(DeviceType deviceType) {
		if (deviceType.getBatchSizePolicy() > 0) {
			error("Batch size policy must be greater than zero",
					HelloWebPackage.Literals.DEVICE_TYPE__BATCH_SIZE_POLICY);
		}
	}


}
