/**
 * generated by Xtext 2.31.0
 */
package org.example.helloweb.helloWeb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.example.helloweb.helloWeb.DeviceType#getName <em>Name</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.DeviceType#getSensorInstantiations <em>Sensor Instantiations</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.DeviceType#getBatchRatePolicy <em>Batch Rate Policy</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.DeviceType#getBatchSizePolicy <em>Batch Size Policy</em>}</li>
 *   <li>{@link org.example.helloweb.helloWeb.DeviceType#getHeartBeatPolicy <em>Heart Beat Policy</em>}</li>
 * </ul>
 *
 * @see org.example.helloweb.helloWeb.HelloWebPackage#getDeviceType()
 * @model
 * @generated
 */
public interface DeviceType extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.example.helloweb.helloWeb.HelloWebPackage#getDeviceType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.example.helloweb.helloWeb.DeviceType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Sensor Instantiations</b></em>' containment reference list.
   * The list contents are of type {@link org.example.helloweb.helloWeb.SensorInstantiation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sensor Instantiations</em>' containment reference list.
   * @see org.example.helloweb.helloWeb.HelloWebPackage#getDeviceType_SensorInstantiations()
   * @model containment="true"
   * @generated
   */
  EList<SensorInstantiation> getSensorInstantiations();

  /**
   * Returns the value of the '<em><b>Batch Rate Policy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Batch Rate Policy</em>' containment reference.
   * @see #setBatchRatePolicy(TimeUnit)
   * @see org.example.helloweb.helloWeb.HelloWebPackage#getDeviceType_BatchRatePolicy()
   * @model containment="true"
   * @generated
   */
  TimeUnit getBatchRatePolicy();

  /**
   * Sets the value of the '{@link org.example.helloweb.helloWeb.DeviceType#getBatchRatePolicy <em>Batch Rate Policy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Batch Rate Policy</em>' containment reference.
   * @see #getBatchRatePolicy()
   * @generated
   */
  void setBatchRatePolicy(TimeUnit value);

  /**
   * Returns the value of the '<em><b>Batch Size Policy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Batch Size Policy</em>' attribute.
   * @see #setBatchSizePolicy(int)
   * @see org.example.helloweb.helloWeb.HelloWebPackage#getDeviceType_BatchSizePolicy()
   * @model
   * @generated
   */
  int getBatchSizePolicy();

  /**
   * Sets the value of the '{@link org.example.helloweb.helloWeb.DeviceType#getBatchSizePolicy <em>Batch Size Policy</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Batch Size Policy</em>' attribute.
   * @see #getBatchSizePolicy()
   * @generated
   */
  void setBatchSizePolicy(int value);

  /**
   * Returns the value of the '<em><b>Heart Beat Policy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Heart Beat Policy</em>' containment reference.
   * @see #setHeartBeatPolicy(TimeUnit)
   * @see org.example.helloweb.helloWeb.HelloWebPackage#getDeviceType_HeartBeatPolicy()
   * @model containment="true"
   * @generated
   */
  TimeUnit getHeartBeatPolicy();

  /**
   * Sets the value of the '{@link org.example.helloweb.helloWeb.DeviceType#getHeartBeatPolicy <em>Heart Beat Policy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Heart Beat Policy</em>' containment reference.
   * @see #getHeartBeatPolicy()
   * @generated
   */
  void setHeartBeatPolicy(TimeUnit value);

} // DeviceType
