/**
 * generated by Xtext 2.31.0
 */
package org.example.helloweb.helloWeb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.example.helloweb.helloWeb.HelloWebPackage;
import org.example.helloweb.helloWeb.SensorInstantiation;
import org.example.helloweb.helloWeb.ValueRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.example.helloweb.helloWeb.impl.ValueRefImpl#getSensorInstantiation <em>Sensor Instantiation</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.impl.ValueRefImpl#getOut <em>Out</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueRefImpl extends ComparisonValueImpl implements ValueRef
{
  /**
   * The cached value of the '{@link #getSensorInstantiation() <em>Sensor Instantiation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSensorInstantiation()
   * @generated
   * @ordered
   */
  protected SensorInstantiation sensorInstantiation;

  /**
   * The default value of the '{@link #getOut() <em>Out</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOut()
   * @generated
   * @ordered
   */
  protected static final String OUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOut() <em>Out</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOut()
   * @generated
   * @ordered
   */
  protected String out = OUT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValueRefImpl()
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
    return HelloWebPackage.Literals.VALUE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SensorInstantiation getSensorInstantiation()
  {
    if (sensorInstantiation != null && sensorInstantiation.eIsProxy())
    {
      InternalEObject oldSensorInstantiation = (InternalEObject)sensorInstantiation;
      sensorInstantiation = (SensorInstantiation)eResolveProxy(oldSensorInstantiation);
      if (sensorInstantiation != oldSensorInstantiation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HelloWebPackage.VALUE_REF__SENSOR_INSTANTIATION, oldSensorInstantiation, sensorInstantiation));
      }
    }
    return sensorInstantiation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SensorInstantiation basicGetSensorInstantiation()
  {
    return sensorInstantiation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSensorInstantiation(SensorInstantiation newSensorInstantiation)
  {
    SensorInstantiation oldSensorInstantiation = sensorInstantiation;
    sensorInstantiation = newSensorInstantiation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelloWebPackage.VALUE_REF__SENSOR_INSTANTIATION, oldSensorInstantiation, sensorInstantiation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOut()
  {
    return out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOut(String newOut)
  {
    String oldOut = out;
    out = newOut;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelloWebPackage.VALUE_REF__OUT, oldOut, out));
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
      case HelloWebPackage.VALUE_REF__SENSOR_INSTANTIATION:
        if (resolve) return getSensorInstantiation();
        return basicGetSensorInstantiation();
      case HelloWebPackage.VALUE_REF__OUT:
        return getOut();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HelloWebPackage.VALUE_REF__SENSOR_INSTANTIATION:
        setSensorInstantiation((SensorInstantiation)newValue);
        return;
      case HelloWebPackage.VALUE_REF__OUT:
        setOut((String)newValue);
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
      case HelloWebPackage.VALUE_REF__SENSOR_INSTANTIATION:
        setSensorInstantiation((SensorInstantiation)null);
        return;
      case HelloWebPackage.VALUE_REF__OUT:
        setOut(OUT_EDEFAULT);
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
      case HelloWebPackage.VALUE_REF__SENSOR_INSTANTIATION:
        return sensorInstantiation != null;
      case HelloWebPackage.VALUE_REF__OUT:
        return OUT_EDEFAULT == null ? out != null : !OUT_EDEFAULT.equals(out);
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
    result.append(" (out: ");
    result.append(out);
    result.append(')');
    return result.toString();
  }

} //ValueRefImpl
