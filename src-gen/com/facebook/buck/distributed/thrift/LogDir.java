/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-09-26")
public class LogDir implements org.apache.thrift.TBase<LogDir, LogDir._Fields>, java.io.Serializable, Cloneable, Comparable<LogDir> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LogDir");

  private static final org.apache.thrift.protocol.TField BUILD_SLAVE_RUN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("buildSlaveRunId", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("data", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ERROR_MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorMessage", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LogDirStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LogDirTupleSchemeFactory());
  }

  public BuildSlaveRunId buildSlaveRunId; // optional
  public ByteBuffer data; // optional
  public String errorMessage; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BUILD_SLAVE_RUN_ID((short)1, "buildSlaveRunId"),
    DATA((short)2, "data"),
    ERROR_MESSAGE((short)3, "errorMessage");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // BUILD_SLAVE_RUN_ID
          return BUILD_SLAVE_RUN_ID;
        case 2: // DATA
          return DATA;
        case 3: // ERROR_MESSAGE
          return ERROR_MESSAGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.BUILD_SLAVE_RUN_ID,_Fields.DATA,_Fields.ERROR_MESSAGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BUILD_SLAVE_RUN_ID, new org.apache.thrift.meta_data.FieldMetaData("buildSlaveRunId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BuildSlaveRunId.class)));
    tmpMap.put(_Fields.DATA, new org.apache.thrift.meta_data.FieldMetaData("data", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.ERROR_MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("errorMessage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LogDir.class, metaDataMap);
  }

  public LogDir() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LogDir(LogDir other) {
    if (other.isSetBuildSlaveRunId()) {
      this.buildSlaveRunId = new BuildSlaveRunId(other.buildSlaveRunId);
    }
    if (other.isSetData()) {
      this.data = org.apache.thrift.TBaseHelper.copyBinary(other.data);
    }
    if (other.isSetErrorMessage()) {
      this.errorMessage = other.errorMessage;
    }
  }

  public LogDir deepCopy() {
    return new LogDir(this);
  }

  @Override
  public void clear() {
    this.buildSlaveRunId = null;
    this.data = null;
    this.errorMessage = null;
  }

  public BuildSlaveRunId getBuildSlaveRunId() {
    return this.buildSlaveRunId;
  }

  public LogDir setBuildSlaveRunId(BuildSlaveRunId buildSlaveRunId) {
    this.buildSlaveRunId = buildSlaveRunId;
    return this;
  }

  public void unsetBuildSlaveRunId() {
    this.buildSlaveRunId = null;
  }

  /** Returns true if field buildSlaveRunId is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildSlaveRunId() {
    return this.buildSlaveRunId != null;
  }

  public void setBuildSlaveRunIdIsSet(boolean value) {
    if (!value) {
      this.buildSlaveRunId = null;
    }
  }

  public byte[] getData() {
    setData(org.apache.thrift.TBaseHelper.rightSize(data));
    return data == null ? null : data.array();
  }

  public ByteBuffer bufferForData() {
    return org.apache.thrift.TBaseHelper.copyBinary(data);
  }

  public LogDir setData(byte[] data) {
    this.data = data == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(data, data.length));
    return this;
  }

  public LogDir setData(ByteBuffer data) {
    this.data = org.apache.thrift.TBaseHelper.copyBinary(data);
    return this;
  }

  public void unsetData() {
    this.data = null;
  }

  /** Returns true if field data is set (has been assigned a value) and false otherwise */
  public boolean isSetData() {
    return this.data != null;
  }

  public void setDataIsSet(boolean value) {
    if (!value) {
      this.data = null;
    }
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }

  public LogDir setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public void unsetErrorMessage() {
    this.errorMessage = null;
  }

  /** Returns true if field errorMessage is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorMessage() {
    return this.errorMessage != null;
  }

  public void setErrorMessageIsSet(boolean value) {
    if (!value) {
      this.errorMessage = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BUILD_SLAVE_RUN_ID:
      if (value == null) {
        unsetBuildSlaveRunId();
      } else {
        setBuildSlaveRunId((BuildSlaveRunId)value);
      }
      break;

    case DATA:
      if (value == null) {
        unsetData();
      } else {
        setData((ByteBuffer)value);
      }
      break;

    case ERROR_MESSAGE:
      if (value == null) {
        unsetErrorMessage();
      } else {
        setErrorMessage((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BUILD_SLAVE_RUN_ID:
      return getBuildSlaveRunId();

    case DATA:
      return getData();

    case ERROR_MESSAGE:
      return getErrorMessage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BUILD_SLAVE_RUN_ID:
      return isSetBuildSlaveRunId();
    case DATA:
      return isSetData();
    case ERROR_MESSAGE:
      return isSetErrorMessage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LogDir)
      return this.equals((LogDir)that);
    return false;
  }

  public boolean equals(LogDir that) {
    if (that == null)
      return false;

    boolean this_present_buildSlaveRunId = true && this.isSetBuildSlaveRunId();
    boolean that_present_buildSlaveRunId = true && that.isSetBuildSlaveRunId();
    if (this_present_buildSlaveRunId || that_present_buildSlaveRunId) {
      if (!(this_present_buildSlaveRunId && that_present_buildSlaveRunId))
        return false;
      if (!this.buildSlaveRunId.equals(that.buildSlaveRunId))
        return false;
    }

    boolean this_present_data = true && this.isSetData();
    boolean that_present_data = true && that.isSetData();
    if (this_present_data || that_present_data) {
      if (!(this_present_data && that_present_data))
        return false;
      if (!this.data.equals(that.data))
        return false;
    }

    boolean this_present_errorMessage = true && this.isSetErrorMessage();
    boolean that_present_errorMessage = true && that.isSetErrorMessage();
    if (this_present_errorMessage || that_present_errorMessage) {
      if (!(this_present_errorMessage && that_present_errorMessage))
        return false;
      if (!this.errorMessage.equals(that.errorMessage))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_buildSlaveRunId = true && (isSetBuildSlaveRunId());
    list.add(present_buildSlaveRunId);
    if (present_buildSlaveRunId)
      list.add(buildSlaveRunId);

    boolean present_data = true && (isSetData());
    list.add(present_data);
    if (present_data)
      list.add(data);

    boolean present_errorMessage = true && (isSetErrorMessage());
    list.add(present_errorMessage);
    if (present_errorMessage)
      list.add(errorMessage);

    return list.hashCode();
  }

  @Override
  public int compareTo(LogDir other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetBuildSlaveRunId()).compareTo(other.isSetBuildSlaveRunId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildSlaveRunId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildSlaveRunId, other.buildSlaveRunId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData()).compareTo(other.isSetData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data, other.data);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetErrorMessage()).compareTo(other.isSetErrorMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorMessage, other.errorMessage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("LogDir(");
    boolean first = true;

    if (isSetBuildSlaveRunId()) {
      sb.append("buildSlaveRunId:");
      if (this.buildSlaveRunId == null) {
        sb.append("null");
      } else {
        sb.append(this.buildSlaveRunId);
      }
      first = false;
    }
    if (isSetData()) {
      if (!first) sb.append(", ");
      sb.append("data:");
      if (this.data == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.data, sb);
      }
      first = false;
    }
    if (isSetErrorMessage()) {
      if (!first) sb.append(", ");
      sb.append("errorMessage:");
      if (this.errorMessage == null) {
        sb.append("null");
      } else {
        sb.append(this.errorMessage);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (buildSlaveRunId != null) {
      buildSlaveRunId.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LogDirStandardSchemeFactory implements SchemeFactory {
    public LogDirStandardScheme getScheme() {
      return new LogDirStandardScheme();
    }
  }

  private static class LogDirStandardScheme extends StandardScheme<LogDir> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LogDir struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BUILD_SLAVE_RUN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.buildSlaveRunId = new BuildSlaveRunId();
              struct.buildSlaveRunId.read(iprot);
              struct.setBuildSlaveRunIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.data = iprot.readBinary();
              struct.setDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ERROR_MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorMessage = iprot.readString();
              struct.setErrorMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, LogDir struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.buildSlaveRunId != null) {
        if (struct.isSetBuildSlaveRunId()) {
          oprot.writeFieldBegin(BUILD_SLAVE_RUN_ID_FIELD_DESC);
          struct.buildSlaveRunId.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.data != null) {
        if (struct.isSetData()) {
          oprot.writeFieldBegin(DATA_FIELD_DESC);
          oprot.writeBinary(struct.data);
          oprot.writeFieldEnd();
        }
      }
      if (struct.errorMessage != null) {
        if (struct.isSetErrorMessage()) {
          oprot.writeFieldBegin(ERROR_MESSAGE_FIELD_DESC);
          oprot.writeString(struct.errorMessage);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LogDirTupleSchemeFactory implements SchemeFactory {
    public LogDirTupleScheme getScheme() {
      return new LogDirTupleScheme();
    }
  }

  private static class LogDirTupleScheme extends TupleScheme<LogDir> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LogDir struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBuildSlaveRunId()) {
        optionals.set(0);
      }
      if (struct.isSetData()) {
        optionals.set(1);
      }
      if (struct.isSetErrorMessage()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetBuildSlaveRunId()) {
        struct.buildSlaveRunId.write(oprot);
      }
      if (struct.isSetData()) {
        oprot.writeBinary(struct.data);
      }
      if (struct.isSetErrorMessage()) {
        oprot.writeString(struct.errorMessage);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LogDir struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.buildSlaveRunId = new BuildSlaveRunId();
        struct.buildSlaveRunId.read(iprot);
        struct.setBuildSlaveRunIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.data = iprot.readBinary();
        struct.setDataIsSet(true);
      }
      if (incoming.get(2)) {
        struct.errorMessage = iprot.readString();
        struct.setErrorMessageIsSet(true);
      }
    }
  }

}

