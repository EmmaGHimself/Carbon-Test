package com.emmagcarbontest.restapi.util

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.*
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.charset.Charset


/*** This is just a FAKE class used for testing purposes only.
 * There is no need to provide implementations for it methods.
 * ***/
class FakeResponseBody: ResponseBody() {
    override fun contentType(): MediaType? {
        return null
    }

    override fun contentLength(): Long {
        return 100000L
    }

    override fun source(): BufferedSource {
        return object: FakeBufferedSource {
            override fun close() {
                TODO("Not yet implemented")
            }

            override fun read(sink: ByteArray): Int {
                TODO("Not yet implemented")
            }

            override fun read(sink: ByteArray, offset: Int, byteCount: Int): Int {
                TODO("Not yet implemented")
            }

            override fun read(sink: Buffer, byteCount: Long): Long {
                TODO("Not yet implemented")
            }

            override fun read(p0: ByteBuffer?): Int {
                TODO("Not yet implemented")
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }

            override fun isOpen(): Boolean {
                TODO("Not yet implemented")
            }

            override fun buffer(): Buffer {
                TODO("Not yet implemented")
            }

            override fun getBuffer(): Buffer {
                TODO("Not yet implemented")
            }

            override fun exhausted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun require(byteCount: Long) {
                TODO("Not yet implemented")
            }

            override fun request(byteCount: Long): Boolean {
                TODO("Not yet implemented")
            }

            override fun readByte(): Byte {
                TODO("Not yet implemented")
            }

            override fun readShort(): Short {
                TODO("Not yet implemented")
            }

            override fun readShortLe(): Short {
                TODO("Not yet implemented")
            }

            override fun readInt(): Int {
                TODO("Not yet implemented")
            }

            override fun readIntLe(): Int {
                TODO("Not yet implemented")
            }

            override fun readLong(): Long {
                TODO("Not yet implemented")
            }

            override fun readLongLe(): Long {
                TODO("Not yet implemented")
            }

            override fun readDecimalLong(): Long {
                TODO("Not yet implemented")
            }

            override fun readHexadecimalUnsignedLong(): Long {
                TODO("Not yet implemented")
            }

            override fun skip(byteCount: Long) {
                TODO("Not yet implemented")
            }

            override fun readByteString(): ByteString {
                TODO("Not yet implemented")
            }

            override fun readByteString(byteCount: Long): ByteString {
                TODO("Not yet implemented")
            }

            override fun select(options: Options): Int {
                TODO("Not yet implemented")
            }

            override fun readByteArray(): ByteArray {
                TODO("Not yet implemented")
            }

            override fun readByteArray(byteCount: Long): ByteArray {
                TODO("Not yet implemented")
            }

            override fun readFully(sink: ByteArray) {
                TODO("Not yet implemented")
            }

            override fun readFully(sink: Buffer, byteCount: Long) {
                TODO("Not yet implemented")
            }

            override fun readAll(sink: Sink): Long {
                TODO("Not yet implemented")
            }

            override fun readUtf8(): String {
                TODO("Not yet implemented")
            }

            override fun readUtf8(byteCount: Long): String {
                TODO("Not yet implemented")
            }

            override fun readUtf8Line(): String? {
                TODO("Not yet implemented")
            }

            override fun readUtf8LineStrict(): String {
                TODO("Not yet implemented")
            }

            override fun readUtf8LineStrict(limit: Long): String {
                TODO("Not yet implemented")
            }

            override fun readUtf8CodePoint(): Int {
                TODO("Not yet implemented")
            }

            override fun readString(charset: Charset): String {
                TODO("Not yet implemented")
            }

            override fun readString(byteCount: Long, charset: Charset): String {
                TODO("Not yet implemented")
            }

            override fun indexOf(b: Byte): Long {
                TODO("Not yet implemented")
            }

            override fun indexOf(b: Byte, fromIndex: Long): Long {
                TODO("Not yet implemented")
            }

            override fun indexOf(b: Byte, fromIndex: Long, toIndex: Long): Long {
                TODO("Not yet implemented")
            }

            override fun indexOf(bytes: ByteString): Long {
                TODO("Not yet implemented")
            }

            override fun indexOf(bytes: ByteString, fromIndex: Long): Long {
                TODO("Not yet implemented")
            }

            override fun indexOfElement(targetBytes: ByteString): Long {
                TODO("Not yet implemented")
            }

            override fun indexOfElement(targetBytes: ByteString, fromIndex: Long): Long {
                TODO("Not yet implemented")
            }

            override fun rangeEquals(offset: Long, bytes: ByteString): Boolean {
                TODO("Not yet implemented")
            }

            override fun rangeEquals(
                offset: Long,
                bytes: ByteString,
                bytesOffset: Int,
                byteCount: Int
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun peek(): BufferedSource {
                TODO("Not yet implemented")
            }

            override fun inputStream(): InputStream {
                TODO("Not yet implemented")
            }

        }
    }


    interface FakeBufferedSource: BufferedSource{

    }
}