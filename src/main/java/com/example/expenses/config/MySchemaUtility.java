package com.example.expenses.config;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;

public class MySchemaUtility{
    Schema employee = SchemaBuilder.record("Employee")
            .namespace("com.example.expenses")
            .fields().requiredString("hostName").requiredString("ipAddress")
            .endRecord();
}
