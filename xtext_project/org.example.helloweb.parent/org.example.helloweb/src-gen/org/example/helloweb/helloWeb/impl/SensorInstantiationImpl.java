/**
 * generated by Xtext 2.33.0
 */
package org.example.helloweb.helloWeb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.example.helloweb.helloWeb.Constraint;
import org.example.helloweb.helloWeb.HelloWebPackage;
import org.example.helloweb.helloWeb.Sensor;
import org.example.helloweb.helloWeb.SensorInstantiation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sensor Instantiation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.example.helloweb.helloWeb.impl.SensorInstantiationImpl#getSensor <em>Sensor</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.impl.SensorInstantiationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.impl.SensorInstantiationImpl#getPins <em>Pins</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.impl.SensorInstantiationImpl#getSamplingRate <em>Sampling Rate</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.impl.SensorInstantiationImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SensorInstantiationImpl extends MinimalEObjectImpl.Container implements SensorInstantiation
{
  /**
   * The cached value of the '{@link #getSensor() <em>Sensor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSensor()
   * @generated
   * @ordered
   */
  protected Sensor sensor;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getPins() <em>Pins</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPins()
   * @generated
   * @ordered
   */
  protected EList<Integer> pins;

  /**
   * The default value of the '{@link #getSamplingRate() <em>Sampling Rate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSamplingRate()
   * @generated
   * @ordered
   */
  protected static final String SAMPLING_RATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSamplingRate() <em>Sampling Rate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSamplingRate()
   * @generated
   * @ordered
   */
  protected String samplingRate = SAMPLING_RATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected EList<Constraint> constraints;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SensorInstantiationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return HelloWebPackage.Literals.SENSOR_INSTANTIATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Sensor getSensor()
  {
    if (sensor != null && sensor.eIsProxy())
    {
      InternalEObject oldSensor = (InternalEObject)sensor;
      sensor = (Sensor)eResolveProxy(oldSensor);
      if (sensor != oldSensor)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HelloWebPackage.SENSOR_INSTANTIATION__SENSOR, oldSensor, sensor));
      }
    }
    return sensor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sensor basicGetSensor()
  {
    return sensor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSensor(Sensor newSensor)
  {
    Sensor oldSensor = sensor;
    sensor = newSensor;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelloWebPackage.SENSOR_INSTANTIATION__SENSOR, oldSensor, sensor));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelloWebPackage.SENSOR_INSTANTIATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Integer> getPins()
  {
    if (pins == null)
    {
      pins = new EDataTypeEList<Integer>(Integer.class, this, HelloWebPackage.SENSOR_INSTANTIATION__PINS);
    }
    return pins;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSamplingRate()
  {
    return samplingRate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSamplingRate(String newSamplingRate)
  {
    String oldSamplingRate = samplingRate;
    samplingRate = newSamplingRate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelloWebPackage.SENSOR_INSTANTIATION__SAMPLING_RATE, oldSamplingRate, samplingRate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Constraint> getConstraints()
  {
    if (constraints == null)
    {
      constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, HelloWebPackage.SENSOR_INSTANTIATION__CONSTRAINTS);
    }
    return constraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case HelloWebPackage.SENSOR_INSTANTIATION__CONSTRAINTS:
        return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case HelloWebPackage.SENSOR_INSTANTIATION__SENSOR:
        if (resolve) return getSensor();
        return basicGetSensor();
      case HelloWebPackage.SENSOR_INSTANTIATION__NAME:
        return getName();
      case HelloWebPackage.SENSOR_INSTANTIATION__PINS:
        return getPins();
      case HelloWebPackage.SENSOR_INSTANTIATION__SAMPLING_RATE:
        return getSamplingRate();
      case HelloWebPackage.SENSOR_INSTANTIATION__CONSTRAINTS:
        return getConstraints();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HelloWebPackage.SENSOR_INSTANTIATION__SENSOR:
        setSensor((Sensor)newValue);
        return;
      case HelloWebPackage.SENSOR_INSTANTIATION__NAME:
        setName((String)newValue);
        return;
      case HelloWebPackage.SENSOR_INSTANTIATION__PINS:
        getPins().clear();
        getPins().addAll((Collection<? extends Integer>)newValue);
        return;
      case HelloWebPackage.SENSOR_INSTANTIATION__SAMPLING_RATE:
        setSamplingRate((String)newValue);
        return;
      case HelloWebPackage.SENSOR_INSTANTIATION__CONSTRAINTS:
        getConstraints().clear();
        getConstraints().addAll((Collection<? extends Constraint>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case HelloWebPackage.SENSOR_INSTANTIATION__SENSOR:
        setSensor((Sensor)null);
        return;
      case HelloWebPackage.SENSOR_INSTANTIATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case HelloWebPackage.SENSOR_INSTANTIATION__PINS:
        getPins().clear();
        return;
      case HelloWebPackage.SENSOR_INSTANTIATION__SAMPLING_RATE:
        setSamplingRate(SAMPLING_RATE_EDEFAULT);
        return;
      case HelloWebPackage.SENSOR_INSTANTIATION__CONSTRAINTS:
        getConstraints().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case HelloWebPackage.SENSOR_INSTANTIATION__SENSOR:
        return sensor != null;
      case HelloWebPackage.SENSOR_INSTANTIATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case HelloWebPackage.SENSOR_INSTANTIATION__PINS:
        return pins != null && !pins.isEmpty();
      case HelloWebPackage.SENSOR_INSTANTIATION__SAMPLING_RATE:
        return SAMPLING_RATE_EDEFAULT == null ? samplingRate != null : !SAMPLING_RATE_EDEFAULT.equals(samplingRate);
      case HelloWebPackage.SENSOR_INSTANTIATION__CONSTRAINTS:
        return constraints != null && !constraints.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", pins: ");
    result.append(pins);
    result.append(", samplingRate: ");
    result.append(samplingRate);
    result.append(')');
    return result.toString();
  }

} //SensorInstantiationImpl
