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
public class RuleKeyLogEntry implements org.apache.thrift.TBase<RuleKeyLogEntry, RuleKeyLogEntry._Fields>, java.io.Serializable, Cloneable, Comparable<RuleKeyLogEntry> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RuleKeyLogEntry");

  private static final org.apache.thrift.protocol.TField RULE_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("ruleKey", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField WAS_STORED_FIELD_DESC = new org.apache.thrift.protocol.TField("wasStored", org.apache.thrift.protocol.TType.BOOL, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_STORED_TIMESTAMP_MILLIS_FIELD_DESC = new org.apache.thrift.protocol.TField("lastStoredTimestampMillis", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField STORE_LOG_ENTRIES_FIELD_DESC = new org.apache.thrift.protocol.TField("storeLogEntries", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RuleKeyLogEntryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RuleKeyLogEntryTupleSchemeFactory());
  }

  public String ruleKey; // optional
  public boolean wasStored; // optional
  public long lastStoredTimestampMillis; // optional
  public List<RuleKeyStoreLogEntry> storeLogEntries; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RULE_KEY((short)1, "ruleKey"),
    WAS_STORED((short)2, "wasStored"),
    LAST_STORED_TIMESTAMP_MILLIS((short)3, "lastStoredTimestampMillis"),
    STORE_LOG_ENTRIES((short)4, "storeLogEntries");

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
        case 1: // RULE_KEY
          return RULE_KEY;
        case 2: // WAS_STORED
          return WAS_STORED;
        case 3: // LAST_STORED_TIMESTAMP_MILLIS
          return LAST_STORED_TIMESTAMP_MILLIS;
        case 4: // STORE_LOG_ENTRIES
          return STORE_LOG_ENTRIES;
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
  private static final int __WASSTORED_ISSET_ID = 0;
  private static final int __LASTSTOREDTIMESTAMPMILLIS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.RULE_KEY,_Fields.WAS_STORED,_Fields.LAST_STORED_TIMESTAMP_MILLIS,_Fields.STORE_LOG_ENTRIES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RULE_KEY, new org.apache.thrift.meta_data.FieldMetaData("ruleKey", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.WAS_STORED, new org.apache.thrift.meta_data.FieldMetaData("wasStored", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.LAST_STORED_TIMESTAMP_MILLIS, new org.apache.thrift.meta_data.FieldMetaData("lastStoredTimestampMillis", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.STORE_LOG_ENTRIES, new org.apache.thrift.meta_data.FieldMetaData("storeLogEntries", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RuleKeyStoreLogEntry.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RuleKeyLogEntry.class, metaDataMap);
  }

  public RuleKeyLogEntry() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RuleKeyLogEntry(RuleKeyLogEntry other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetRuleKey()) {
      this.ruleKey = other.ruleKey;
    }
    this.wasStored = other.wasStored;
    this.lastStoredTimestampMillis = other.lastStoredTimestampMillis;
    if (other.isSetStoreLogEntries()) {
      List<RuleKeyStoreLogEntry> __this__storeLogEntries = new ArrayList<RuleKeyStoreLogEntry>(other.storeLogEntries.size());
      for (RuleKeyStoreLogEntry other_element : other.storeLogEntries) {
        __this__storeLogEntries.add(new RuleKeyStoreLogEntry(other_element));
      }
      this.storeLogEntries = __this__storeLogEntries;
    }
  }

  public RuleKeyLogEntry deepCopy() {
    return new RuleKeyLogEntry(this);
  }

  @Override
  public void clear() {
    this.ruleKey = null;
    setWasStoredIsSet(false);
    this.wasStored = false;
    setLastStoredTimestampMillisIsSet(false);
    this.lastStoredTimestampMillis = 0;
    this.storeLogEntries = null;
  }

  public String getRuleKey() {
    return this.ruleKey;
  }

  public RuleKeyLogEntry setRuleKey(String ruleKey) {
    this.ruleKey = ruleKey;
    return this;
  }

  public void unsetRuleKey() {
    this.ruleKey = null;
  }

  /** Returns true if field ruleKey is set (has been assigned a value) and false otherwise */
  public boolean isSetRuleKey() {
    return this.ruleKey != null;
  }

  public void setRuleKeyIsSet(boolean value) {
    if (!value) {
      this.ruleKey = null;
    }
  }

  public boolean isWasStored() {
    return this.wasStored;
  }

  public RuleKeyLogEntry setWasStored(boolean wasStored) {
    this.wasStored = wasStored;
    setWasStoredIsSet(true);
    return this;
  }

  public void unsetWasStored() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WASSTORED_ISSET_ID);
  }

  /** Returns true if field wasStored is set (has been assigned a value) and false otherwise */
  public boolean isSetWasStored() {
    return EncodingUtils.testBit(__isset_bitfield, __WASSTORED_ISSET_ID);
  }

  public void setWasStoredIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WASSTORED_ISSET_ID, value);
  }

  public long getLastStoredTimestampMillis() {
    return this.lastStoredTimestampMillis;
  }

  public RuleKeyLogEntry setLastStoredTimestampMillis(long lastStoredTimestampMillis) {
    this.lastStoredTimestampMillis = lastStoredTimestampMillis;
    setLastStoredTimestampMillisIsSet(true);
    return this;
  }

  public void unsetLastStoredTimestampMillis() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTSTOREDTIMESTAMPMILLIS_ISSET_ID);
  }

  /** Returns true if field lastStoredTimestampMillis is set (has been assigned a value) and false otherwise */
  public boolean isSetLastStoredTimestampMillis() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTSTOREDTIMESTAMPMILLIS_ISSET_ID);
  }

  public void setLastStoredTimestampMillisIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTSTOREDTIMESTAMPMILLIS_ISSET_ID, value);
  }

  public int getStoreLogEntriesSize() {
    return (this.storeLogEntries == null) ? 0 : this.storeLogEntries.size();
  }

  public java.util.Iterator<RuleKeyStoreLogEntry> getStoreLogEntriesIterator() {
    return (this.storeLogEntries == null) ? null : this.storeLogEntries.iterator();
  }

  public void addToStoreLogEntries(RuleKeyStoreLogEntry elem) {
    if (this.storeLogEntries == null) {
      this.storeLogEntries = new ArrayList<RuleKeyStoreLogEntry>();
    }
    this.storeLogEntries.add(elem);
  }

  public List<RuleKeyStoreLogEntry> getStoreLogEntries() {
    return this.storeLogEntries;
  }

  public RuleKeyLogEntry setStoreLogEntries(List<RuleKeyStoreLogEntry> storeLogEntries) {
    this.storeLogEntries = storeLogEntries;
    return this;
  }

  public void unsetStoreLogEntries() {
    this.storeLogEntries = null;
  }

  /** Returns true if field storeLogEntries is set (has been assigned a value) and false otherwise */
  public boolean isSetStoreLogEntries() {
    return this.storeLogEntries != null;
  }

  public void setStoreLogEntriesIsSet(boolean value) {
    if (!value) {
      this.storeLogEntries = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RULE_KEY:
      if (value == null) {
        unsetRuleKey();
      } else {
        setRuleKey((String)value);
      }
      break;

    case WAS_STORED:
      if (value == null) {
        unsetWasStored();
      } else {
        setWasStored((Boolean)value);
      }
      break;

    case LAST_STORED_TIMESTAMP_MILLIS:
      if (value == null) {
        unsetLastStoredTimestampMillis();
      } else {
        setLastStoredTimestampMillis((Long)value);
      }
      break;

    case STORE_LOG_ENTRIES:
      if (value == null) {
        unsetStoreLogEntries();
      } else {
        setStoreLogEntries((List<RuleKeyStoreLogEntry>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RULE_KEY:
      return getRuleKey();

    case WAS_STORED:
      return isWasStored();

    case LAST_STORED_TIMESTAMP_MILLIS:
      return getLastStoredTimestampMillis();

    case STORE_LOG_ENTRIES:
      return getStoreLogEntries();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RULE_KEY:
      return isSetRuleKey();
    case WAS_STORED:
      return isSetWasStored();
    case LAST_STORED_TIMESTAMP_MILLIS:
      return isSetLastStoredTimestampMillis();
    case STORE_LOG_ENTRIES:
      return isSetStoreLogEntries();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RuleKeyLogEntry)
      return this.equals((RuleKeyLogEntry)that);
    return false;
  }

  public boolean equals(RuleKeyLogEntry that) {
    if (that == null)
      return false;

    boolean this_present_ruleKey = true && this.isSetRuleKey();
    boolean that_present_ruleKey = true && that.isSetRuleKey();
    if (this_present_ruleKey || that_present_ruleKey) {
      if (!(this_present_ruleKey && that_present_ruleKey))
        return false;
      if (!this.ruleKey.equals(that.ruleKey))
        return false;
    }

    boolean this_present_wasStored = true && this.isSetWasStored();
    boolean that_present_wasStored = true && that.isSetWasStored();
    if (this_present_wasStored || that_present_wasStored) {
      if (!(this_present_wasStored && that_present_wasStored))
        return false;
      if (this.wasStored != that.wasStored)
        return false;
    }

    boolean this_present_lastStoredTimestampMillis = true && this.isSetLastStoredTimestampMillis();
    boolean that_present_lastStoredTimestampMillis = true && that.isSetLastStoredTimestampMillis();
    if (this_present_lastStoredTimestampMillis || that_present_lastStoredTimestampMillis) {
      if (!(this_present_lastStoredTimestampMillis && that_present_lastStoredTimestampMillis))
        return false;
      if (this.lastStoredTimestampMillis != that.lastStoredTimestampMillis)
        return false;
    }

    boolean this_present_storeLogEntries = true && this.isSetStoreLogEntries();
    boolean that_present_storeLogEntries = true && that.isSetStoreLogEntries();
    if (this_present_storeLogEntries || that_present_storeLogEntries) {
      if (!(this_present_storeLogEntries && that_present_storeLogEntries))
        return false;
      if (!this.storeLogEntries.equals(that.storeLogEntries))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_ruleKey = true && (isSetRuleKey());
    list.add(present_ruleKey);
    if (present_ruleKey)
      list.add(ruleKey);

    boolean present_wasStored = true && (isSetWasStored());
    list.add(present_wasStored);
    if (present_wasStored)
      list.add(wasStored);

    boolean present_lastStoredTimestampMillis = true && (isSetLastStoredTimestampMillis());
    list.add(present_lastStoredTimestampMillis);
    if (present_lastStoredTimestampMillis)
      list.add(lastStoredTimestampMillis);

    boolean present_storeLogEntries = true && (isSetStoreLogEntries());
    list.add(present_storeLogEntries);
    if (present_storeLogEntries)
      list.add(storeLogEntries);

    return list.hashCode();
  }

  @Override
  public int compareTo(RuleKeyLogEntry other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRuleKey()).compareTo(other.isSetRuleKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRuleKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ruleKey, other.ruleKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWasStored()).compareTo(other.isSetWasStored());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWasStored()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.wasStored, other.wasStored);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastStoredTimestampMillis()).compareTo(other.isSetLastStoredTimestampMillis());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastStoredTimestampMillis()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastStoredTimestampMillis, other.lastStoredTimestampMillis);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStoreLogEntries()).compareTo(other.isSetStoreLogEntries());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStoreLogEntries()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.storeLogEntries, other.storeLogEntries);
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
    StringBuilder sb = new StringBuilder("RuleKeyLogEntry(");
    boolean first = true;

    if (isSetRuleKey()) {
      sb.append("ruleKey:");
      if (this.ruleKey == null) {
        sb.append("null");
      } else {
        sb.append(this.ruleKey);
      }
      first = false;
    }
    if (isSetWasStored()) {
      if (!first) sb.append(", ");
      sb.append("wasStored:");
      sb.append(this.wasStored);
      first = false;
    }
    if (isSetLastStoredTimestampMillis()) {
      if (!first) sb.append(", ");
      sb.append("lastStoredTimestampMillis:");
      sb.append(this.lastStoredTimestampMillis);
      first = false;
    }
    if (isSetStoreLogEntries()) {
      if (!first) sb.append(", ");
      sb.append("storeLogEntries:");
      if (this.storeLogEntries == null) {
        sb.append("null");
      } else {
        sb.append(this.storeLogEntries);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RuleKeyLogEntryStandardSchemeFactory implements SchemeFactory {
    public RuleKeyLogEntryStandardScheme getScheme() {
      return new RuleKeyLogEntryStandardScheme();
    }
  }

  private static class RuleKeyLogEntryStandardScheme extends StandardScheme<RuleKeyLogEntry> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RuleKeyLogEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RULE_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ruleKey = iprot.readString();
              struct.setRuleKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // WAS_STORED
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.wasStored = iprot.readBool();
              struct.setWasStoredIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LAST_STORED_TIMESTAMP_MILLIS
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.lastStoredTimestampMillis = iprot.readI64();
              struct.setLastStoredTimestampMillisIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STORE_LOG_ENTRIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list170 = iprot.readListBegin();
                struct.storeLogEntries = new ArrayList<RuleKeyStoreLogEntry>(_list170.size);
                RuleKeyStoreLogEntry _elem171;
                for (int _i172 = 0; _i172 < _list170.size; ++_i172)
                {
                  _elem171 = new RuleKeyStoreLogEntry();
                  _elem171.read(iprot);
                  struct.storeLogEntries.add(_elem171);
                }
                iprot.readListEnd();
              }
              struct.setStoreLogEntriesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RuleKeyLogEntry struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ruleKey != null) {
        if (struct.isSetRuleKey()) {
          oprot.writeFieldBegin(RULE_KEY_FIELD_DESC);
          oprot.writeString(struct.ruleKey);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetWasStored()) {
        oprot.writeFieldBegin(WAS_STORED_FIELD_DESC);
        oprot.writeBool(struct.wasStored);
        oprot.writeFieldEnd();
      }
      if (struct.isSetLastStoredTimestampMillis()) {
        oprot.writeFieldBegin(LAST_STORED_TIMESTAMP_MILLIS_FIELD_DESC);
        oprot.writeI64(struct.lastStoredTimestampMillis);
        oprot.writeFieldEnd();
      }
      if (struct.storeLogEntries != null) {
        if (struct.isSetStoreLogEntries()) {
          oprot.writeFieldBegin(STORE_LOG_ENTRIES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.storeLogEntries.size()));
            for (RuleKeyStoreLogEntry _iter173 : struct.storeLogEntries)
            {
              _iter173.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RuleKeyLogEntryTupleSchemeFactory implements SchemeFactory {
    public RuleKeyLogEntryTupleScheme getScheme() {
      return new RuleKeyLogEntryTupleScheme();
    }
  }

  private static class RuleKeyLogEntryTupleScheme extends TupleScheme<RuleKeyLogEntry> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RuleKeyLogEntry struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetRuleKey()) {
        optionals.set(0);
      }
      if (struct.isSetWasStored()) {
        optionals.set(1);
      }
      if (struct.isSetLastStoredTimestampMillis()) {
        optionals.set(2);
      }
      if (struct.isSetStoreLogEntries()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetRuleKey()) {
        oprot.writeString(struct.ruleKey);
      }
      if (struct.isSetWasStored()) {
        oprot.writeBool(struct.wasStored);
      }
      if (struct.isSetLastStoredTimestampMillis()) {
        oprot.writeI64(struct.lastStoredTimestampMillis);
      }
      if (struct.isSetStoreLogEntries()) {
        {
          oprot.writeI32(struct.storeLogEntries.size());
          for (RuleKeyStoreLogEntry _iter174 : struct.storeLogEntries)
          {
            _iter174.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RuleKeyLogEntry struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.ruleKey = iprot.readString();
        struct.setRuleKeyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.wasStored = iprot.readBool();
        struct.setWasStoredIsSet(true);
      }
      if (incoming.get(2)) {
        struct.lastStoredTimestampMillis = iprot.readI64();
        struct.setLastStoredTimestampMillisIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list175 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.storeLogEntries = new ArrayList<RuleKeyStoreLogEntry>(_list175.size);
          RuleKeyStoreLogEntry _elem176;
          for (int _i177 = 0; _i177 < _list175.size; ++_i177)
          {
            _elem176 = new RuleKeyStoreLogEntry();
            _elem176.read(iprot);
            struct.storeLogEntries.add(_elem176);
          }
        }
        struct.setStoreLogEntriesIsSet(true);
      }
    }
  }

}

