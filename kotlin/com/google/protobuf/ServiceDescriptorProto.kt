// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.TagHandler
import com.squareup.wire.WireField
import com.squareup.wire.internal.Internal
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * Describes a service.
 */
data class ServiceDescriptorProto(
  @field:WireField(tag = 1, adapter = "com.squareup.wire.ProtoAdapter#STRING") val name: String? =
      null,
  @field:WireField(tag = 2, adapter = "com.google.protobuf.MethodDescriptorProto#ADAPTER")
      val method: List<MethodDescriptorProto> = emptyList(),
  @field:WireField(tag = 3, adapter = "com.google.protobuf.ServiceOptions#ADAPTER") val options:
      ServiceOptions? = null,
  val unknownFields: ByteString = ByteString.EMPTY
) : Message<ServiceDescriptorProto, ServiceDescriptorProto.Builder>(ADAPTER, unknownFields) {
  @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Builder = Builder(this.copy())

  class Builder(private val message: ServiceDescriptorProto) :
      Message.Builder<ServiceDescriptorProto, Builder>() {
    override fun build(): ServiceDescriptorProto = message
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ServiceDescriptorProto> = object :
        ProtoAdapter<ServiceDescriptorProto>(
      FieldEncoding.LENGTH_DELIMITED, 
      ServiceDescriptorProto::class.java
    ) {
      override fun encodedSize(value: ServiceDescriptorProto): Int = 
        ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) +
        MethodDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, value.method) +
        ServiceOptions.ADAPTER.encodedSizeWithTag(3, value.options) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: ServiceDescriptorProto) {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        MethodDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.method)
        ServiceOptions.ADAPTER.encodeWithTag(writer, 3, value.options)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ServiceDescriptorProto {
        var name: String? = null
        val method = mutableListOf<MethodDescriptorProto>()
        var options: ServiceOptions? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> method.add(MethodDescriptorProto.ADAPTER.decode(reader))
            3 -> options = ServiceOptions.ADAPTER.decode(reader)
            else -> TagHandler.UNKNOWN_TAG
          }
        }
        return ServiceDescriptorProto(
          name = name,
          method = method,
          options = options,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ServiceDescriptorProto): ServiceDescriptorProto? = value.copy(
        method = value.method.also { Internal.redactElements(it, MethodDescriptorProto.ADAPTER) },
        options = value.options?.let(ServiceOptions.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
