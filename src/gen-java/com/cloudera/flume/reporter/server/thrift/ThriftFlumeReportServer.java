/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.cloudera.flume.reporter.server.thrift;

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
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class ThriftFlumeReportServer {

  public interface Iface {

    public Map<String,ThriftFlumeReport> getAllReports() throws TException;

    public ThriftFlumeReport getReportByName(String reportName) throws TException;

  }

  public static class Client implements Iface {
    public Client(TProtocol prot)
    {
      this(prot, prot);
    }

    public Client(TProtocol iprot, TProtocol oprot)
    {
      iprot_ = iprot;
      oprot_ = oprot;
    }

    protected TProtocol iprot_;
    protected TProtocol oprot_;

    protected int seqid_;

    public TProtocol getInputProtocol()
    {
      return this.iprot_;
    }

    public TProtocol getOutputProtocol()
    {
      return this.oprot_;
    }

    public Map<String,ThriftFlumeReport> getAllReports() throws TException
    {
      send_getAllReports();
      return recv_getAllReports();
    }

    public void send_getAllReports() throws TException
    {
      oprot_.writeMessageBegin(new TMessage("getAllReports", TMessageType.CALL, seqid_));
      getAllReports_args args = new getAllReports_args();
      args.write(oprot_);
      oprot_.writeMessageEnd();
      oprot_.getTransport().flush();
    }

    public Map<String,ThriftFlumeReport> recv_getAllReports() throws TException
    {
      TMessage msg = iprot_.readMessageBegin();
      if (msg.type == TMessageType.EXCEPTION) {
        TApplicationException x = TApplicationException.read(iprot_);
        iprot_.readMessageEnd();
        throw x;
      }
      getAllReports_result result = new getAllReports_result();
      result.read(iprot_);
      iprot_.readMessageEnd();
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new TApplicationException(TApplicationException.MISSING_RESULT, "getAllReports failed: unknown result");
    }

    public ThriftFlumeReport getReportByName(String reportName) throws TException
    {
      send_getReportByName(reportName);
      return recv_getReportByName();
    }

    public void send_getReportByName(String reportName) throws TException
    {
      oprot_.writeMessageBegin(new TMessage("getReportByName", TMessageType.CALL, seqid_));
      getReportByName_args args = new getReportByName_args();
      args.reportName = reportName;
      args.write(oprot_);
      oprot_.writeMessageEnd();
      oprot_.getTransport().flush();
    }

    public ThriftFlumeReport recv_getReportByName() throws TException
    {
      TMessage msg = iprot_.readMessageBegin();
      if (msg.type == TMessageType.EXCEPTION) {
        TApplicationException x = TApplicationException.read(iprot_);
        iprot_.readMessageEnd();
        throw x;
      }
      getReportByName_result result = new getReportByName_result();
      result.read(iprot_);
      iprot_.readMessageEnd();
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new TApplicationException(TApplicationException.MISSING_RESULT, "getReportByName failed: unknown result");
    }

  }
  public static class Processor implements TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(Iface iface)
    {
      iface_ = iface;
      processMap_.put("getAllReports", new getAllReports());
      processMap_.put("getReportByName", new getReportByName());
    }

    protected static interface ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException;
    }

    private Iface iface_;
    protected final HashMap<String,ProcessFunction> processMap_ = new HashMap<String,ProcessFunction>();

    public boolean process(TProtocol iprot, TProtocol oprot) throws TException
    {
      TMessage msg = iprot.readMessageBegin();
      ProcessFunction fn = processMap_.get(msg.name);
      if (fn == null) {
        TProtocolUtil.skip(iprot, TType.STRUCT);
        iprot.readMessageEnd();
        TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '"+msg.name+"'");
        oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
        x.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
        return true;
      }
      fn.process(msg.seqid, iprot, oprot);
      return true;
    }

    private class getAllReports implements ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException
      {
        getAllReports_args args = new getAllReports_args();
        args.read(iprot);
        iprot.readMessageEnd();
        getAllReports_result result = new getAllReports_result();
        result.success = iface_.getAllReports();
        oprot.writeMessageBegin(new TMessage("getAllReports", TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
      }

    }

    private class getReportByName implements ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException
      {
        getReportByName_args args = new getReportByName_args();
        args.read(iprot);
        iprot.readMessageEnd();
        getReportByName_result result = new getReportByName_result();
        result.success = iface_.getReportByName(args.reportName);
        oprot.writeMessageBegin(new TMessage("getReportByName", TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
      }

    }

  }

  public static class getAllReports_args implements TBase<getAllReports_args._Fields>, java.io.Serializable, Cloneable, Comparable<getAllReports_args>   {
    private static final TStruct STRUCT_DESC = new TStruct("getAllReports_args");



    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements TFieldIdEnum {
;

      private static final Map<Integer, _Fields> byId = new HashMap<Integer, _Fields>();
      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byId.put((int)field._thriftId, field);
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        return byId.get(fieldId);
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
    public static final Map<_Fields, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new EnumMap<_Fields, FieldMetaData>(_Fields.class) {{
    }});

    static {
      FieldMetaData.addStructMetaDataMap(getAllReports_args.class, metaDataMap);
    }

    public getAllReports_args() {
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getAllReports_args(getAllReports_args other) {
    }

    public getAllReports_args deepCopy() {
      return new getAllReports_args(this);
    }

    @Deprecated
    public getAllReports_args clone() {
      return new getAllReports_args(this);
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      }
    }

    public void setFieldValue(int fieldID, Object value) {
      setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      }
      throw new IllegalStateException();
    }

    public Object getFieldValue(int fieldId) {
      return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
    }

    /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      switch (field) {
      }
      throw new IllegalStateException();
    }

    public boolean isSet(int fieldID) {
      return isSet(_Fields.findByThriftIdOrThrow(fieldID));
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getAllReports_args)
        return this.equals((getAllReports_args)that);
      return false;
    }

    public boolean equals(getAllReports_args that) {
      if (that == null)
        return false;

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(getAllReports_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      getAllReports_args typedOther = (getAllReports_args)other;

      return 0;
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        _Fields fieldId = _Fields.findByThriftId(field.id);
        if (fieldId == null) {
          TProtocolUtil.skip(iprot, field.type);
        } else {
          switch (fieldId) {
          }
          iprot.readFieldEnd();
        }
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(TProtocol oprot) throws TException {
      validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getAllReports_args(");
      boolean first = true;

      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
    }

  }

  public static class getAllReports_result implements TBase<getAllReports_result._Fields>, java.io.Serializable, Cloneable   {
    private static final TStruct STRUCT_DESC = new TStruct("getAllReports_result");

    private static final TField SUCCESS_FIELD_DESC = new TField("success", TType.MAP, (short)0);

    public Map<String,ThriftFlumeReport> success;

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<Integer, _Fields> byId = new HashMap<Integer, _Fields>();
      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byId.put((int)field._thriftId, field);
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        return byId.get(fieldId);
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

    public static final Map<_Fields, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new EnumMap<_Fields, FieldMetaData>(_Fields.class) {{
      put(_Fields.SUCCESS, new FieldMetaData("success", TFieldRequirementType.DEFAULT, 
          new MapMetaData(TType.MAP, 
              new FieldValueMetaData(TType.STRING), 
              new StructMetaData(TType.STRUCT, ThriftFlumeReport.class))));
    }});

    static {
      FieldMetaData.addStructMetaDataMap(getAllReports_result.class, metaDataMap);
    }

    public getAllReports_result() {
    }

    public getAllReports_result(
      Map<String,ThriftFlumeReport> success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getAllReports_result(getAllReports_result other) {
      if (other.isSetSuccess()) {
        Map<String,ThriftFlumeReport> __this__success = new HashMap<String,ThriftFlumeReport>();
        for (Map.Entry<String, ThriftFlumeReport> other_element : other.success.entrySet()) {

          String other_element_key = other_element.getKey();
          ThriftFlumeReport other_element_value = other_element.getValue();

          String __this__success_copy_key = other_element_key;

          ThriftFlumeReport __this__success_copy_value = new ThriftFlumeReport(other_element_value);

          __this__success.put(__this__success_copy_key, __this__success_copy_value);
        }
        this.success = __this__success;
      }
    }

    public getAllReports_result deepCopy() {
      return new getAllReports_result(this);
    }

    @Deprecated
    public getAllReports_result clone() {
      return new getAllReports_result(this);
    }

    public int getSuccessSize() {
      return (this.success == null) ? 0 : this.success.size();
    }

    public void putToSuccess(String key, ThriftFlumeReport val) {
      if (this.success == null) {
        this.success = new HashMap<String,ThriftFlumeReport>();
      }
      this.success.put(key, val);
    }

    public Map<String,ThriftFlumeReport> getSuccess() {
      return this.success;
    }

    public getAllReports_result setSuccess(Map<String,ThriftFlumeReport> success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been asigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((Map<String,ThriftFlumeReport>)value);
        }
        break;

      }
    }

    public void setFieldValue(int fieldID, Object value) {
      setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    public Object getFieldValue(int fieldId) {
      return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
    }

    /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    public boolean isSet(int fieldID) {
      return isSet(_Fields.findByThriftIdOrThrow(fieldID));
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getAllReports_result)
        return this.equals((getAllReports_result)that);
      return false;
    }

    public boolean equals(getAllReports_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        _Fields fieldId = _Fields.findByThriftId(field.id);
        if (fieldId == null) {
          TProtocolUtil.skip(iprot, field.type);
        } else {
          switch (fieldId) {
            case SUCCESS:
              if (field.type == TType.MAP) {
                {
                  TMap _map15 = iprot.readMapBegin();
                  this.success = new HashMap<String,ThriftFlumeReport>(2*_map15.size);
                  for (int _i16 = 0; _i16 < _map15.size; ++_i16)
                  {
                    String _key17;
                    ThriftFlumeReport _val18;
                    _key17 = iprot.readString();
                    _val18 = new ThriftFlumeReport();
                    _val18.read(iprot);
                    this.success.put(_key17, _val18);
                  }
                  iprot.readMapEnd();
                }
              } else { 
                TProtocolUtil.skip(iprot, field.type);
              }
              break;
          }
          iprot.readFieldEnd();
        }
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(TProtocol oprot) throws TException {
      oprot.writeStructBegin(STRUCT_DESC);

      if (this.isSetSuccess()) {
        oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        {
          oprot.writeMapBegin(new TMap(TType.STRING, TType.STRUCT, this.success.size()));
          for (Map.Entry<String, ThriftFlumeReport> _iter19 : this.success.entrySet())
          {
            oprot.writeString(_iter19.getKey());
            _iter19.getValue().write(oprot);
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getAllReports_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
    }

  }

  public static class getReportByName_args implements TBase<getReportByName_args._Fields>, java.io.Serializable, Cloneable, Comparable<getReportByName_args>   {
    private static final TStruct STRUCT_DESC = new TStruct("getReportByName_args");

    private static final TField REPORT_NAME_FIELD_DESC = new TField("reportName", TType.STRING, (short)1);

    public String reportName;

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements TFieldIdEnum {
      REPORT_NAME((short)1, "reportName");

      private static final Map<Integer, _Fields> byId = new HashMap<Integer, _Fields>();
      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byId.put((int)field._thriftId, field);
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        return byId.get(fieldId);
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

    public static final Map<_Fields, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new EnumMap<_Fields, FieldMetaData>(_Fields.class) {{
      put(_Fields.REPORT_NAME, new FieldMetaData("reportName", TFieldRequirementType.DEFAULT, 
          new FieldValueMetaData(TType.STRING)));
    }});

    static {
      FieldMetaData.addStructMetaDataMap(getReportByName_args.class, metaDataMap);
    }

    public getReportByName_args() {
    }

    public getReportByName_args(
      String reportName)
    {
      this();
      this.reportName = reportName;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getReportByName_args(getReportByName_args other) {
      if (other.isSetReportName()) {
        this.reportName = other.reportName;
      }
    }

    public getReportByName_args deepCopy() {
      return new getReportByName_args(this);
    }

    @Deprecated
    public getReportByName_args clone() {
      return new getReportByName_args(this);
    }

    public String getReportName() {
      return this.reportName;
    }

    public getReportByName_args setReportName(String reportName) {
      this.reportName = reportName;
      return this;
    }

    public void unsetReportName() {
      this.reportName = null;
    }

    /** Returns true if field reportName is set (has been asigned a value) and false otherwise */
    public boolean isSetReportName() {
      return this.reportName != null;
    }

    public void setReportNameIsSet(boolean value) {
      if (!value) {
        this.reportName = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case REPORT_NAME:
        if (value == null) {
          unsetReportName();
        } else {
          setReportName((String)value);
        }
        break;

      }
    }

    public void setFieldValue(int fieldID, Object value) {
      setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case REPORT_NAME:
        return getReportName();

      }
      throw new IllegalStateException();
    }

    public Object getFieldValue(int fieldId) {
      return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
    }

    /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      switch (field) {
      case REPORT_NAME:
        return isSetReportName();
      }
      throw new IllegalStateException();
    }

    public boolean isSet(int fieldID) {
      return isSet(_Fields.findByThriftIdOrThrow(fieldID));
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getReportByName_args)
        return this.equals((getReportByName_args)that);
      return false;
    }

    public boolean equals(getReportByName_args that) {
      if (that == null)
        return false;

      boolean this_present_reportName = true && this.isSetReportName();
      boolean that_present_reportName = true && that.isSetReportName();
      if (this_present_reportName || that_present_reportName) {
        if (!(this_present_reportName && that_present_reportName))
          return false;
        if (!this.reportName.equals(that.reportName))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(getReportByName_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      getReportByName_args typedOther = (getReportByName_args)other;

      lastComparison = Boolean.valueOf(isSetReportName()).compareTo(isSetReportName());
      if (lastComparison != 0) {
        return lastComparison;
      }
      lastComparison = TBaseHelper.compareTo(reportName, typedOther.reportName);
      if (lastComparison != 0) {
        return lastComparison;
      }
      return 0;
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        _Fields fieldId = _Fields.findByThriftId(field.id);
        if (fieldId == null) {
          TProtocolUtil.skip(iprot, field.type);
        } else {
          switch (fieldId) {
            case REPORT_NAME:
              if (field.type == TType.STRING) {
                this.reportName = iprot.readString();
              } else { 
                TProtocolUtil.skip(iprot, field.type);
              }
              break;
          }
          iprot.readFieldEnd();
        }
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(TProtocol oprot) throws TException {
      validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (this.reportName != null) {
        oprot.writeFieldBegin(REPORT_NAME_FIELD_DESC);
        oprot.writeString(this.reportName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getReportByName_args(");
      boolean first = true;

      sb.append("reportName:");
      if (this.reportName == null) {
        sb.append("null");
      } else {
        sb.append(this.reportName);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
    }

  }

  public static class getReportByName_result implements TBase<getReportByName_result._Fields>, java.io.Serializable, Cloneable   {
    private static final TStruct STRUCT_DESC = new TStruct("getReportByName_result");

    private static final TField SUCCESS_FIELD_DESC = new TField("success", TType.STRUCT, (short)0);

    public ThriftFlumeReport success;

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements TFieldIdEnum {
      SUCCESS((short)0, "success");

      private static final Map<Integer, _Fields> byId = new HashMap<Integer, _Fields>();
      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byId.put((int)field._thriftId, field);
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        return byId.get(fieldId);
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

    public static final Map<_Fields, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new EnumMap<_Fields, FieldMetaData>(_Fields.class) {{
      put(_Fields.SUCCESS, new FieldMetaData("success", TFieldRequirementType.DEFAULT, 
          new StructMetaData(TType.STRUCT, ThriftFlumeReport.class)));
    }});

    static {
      FieldMetaData.addStructMetaDataMap(getReportByName_result.class, metaDataMap);
    }

    public getReportByName_result() {
    }

    public getReportByName_result(
      ThriftFlumeReport success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getReportByName_result(getReportByName_result other) {
      if (other.isSetSuccess()) {
        this.success = new ThriftFlumeReport(other.success);
      }
    }

    public getReportByName_result deepCopy() {
      return new getReportByName_result(this);
    }

    @Deprecated
    public getReportByName_result clone() {
      return new getReportByName_result(this);
    }

    public ThriftFlumeReport getSuccess() {
      return this.success;
    }

    public getReportByName_result setSuccess(ThriftFlumeReport success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been asigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((ThriftFlumeReport)value);
        }
        break;

      }
    }

    public void setFieldValue(int fieldID, Object value) {
      setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    public Object getFieldValue(int fieldId) {
      return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
    }

    /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    public boolean isSet(int fieldID) {
      return isSet(_Fields.findByThriftIdOrThrow(fieldID));
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getReportByName_result)
        return this.equals((getReportByName_result)that);
      return false;
    }

    public boolean equals(getReportByName_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public void read(TProtocol iprot) throws TException {
      TField field;
      iprot.readStructBegin();
      while (true)
      {
        field = iprot.readFieldBegin();
        if (field.type == TType.STOP) { 
          break;
        }
        _Fields fieldId = _Fields.findByThriftId(field.id);
        if (fieldId == null) {
          TProtocolUtil.skip(iprot, field.type);
        } else {
          switch (fieldId) {
            case SUCCESS:
              if (field.type == TType.STRUCT) {
                this.success = new ThriftFlumeReport();
                this.success.read(iprot);
              } else { 
                TProtocolUtil.skip(iprot, field.type);
              }
              break;
          }
          iprot.readFieldEnd();
        }
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      validate();
    }

    public void write(TProtocol oprot) throws TException {
      oprot.writeStructBegin(STRUCT_DESC);

      if (this.isSetSuccess()) {
        oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
        this.success.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getReportByName_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
    }

  }

}