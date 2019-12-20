package com.domain.lesson15;

import java.nio.ByteBuffer;

public class NIOBuffer {
    public static void main(String[] args) {
//буферы могут быть таких типов данных:
        /*ByteBuffer
        MappedByteBuffer
        CharBuffer
        DoubleBuffer
        FloatBuffer
        IntBuffer
        LongBuffer
        ShortBuffer*/

        ByteBuffer buffer = ByteBuffer.allocate(16); //создаем буффер указанного размера
        assert buffer.position() == 0; //курсор /когда ставится ассерт - то предполагается,что утверждение верное. если не верное,то будет иксепшн. по умолчанию выключены. включить в конфигурации -ea
        assert buffer.capacity() == 16; //емкость
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16; // разница между position и limit

        // Увеличивает позицию на 4.
        buffer.putInt(100);

        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 8.
        buffer.putDouble(100.25);

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        // Устанавливает лимит на место позиции, сбрасывает позицию в 0. //чтобы не работать с пустотой
        buffer.flip();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        int anInt = buffer.getInt();

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        // Увеличивает позицию на 8.
        double aDouble = buffer.getDouble();

        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        // Сбрасывает позицию в 0.
        buffer.rewind();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        assert anInt == buffer.getInt();
        // Увеличивает позицию на 8.
        assert aDouble == buffer.getDouble();

        // Сбрасывает позицию в 0, ставит лимит, равный емкости буфера
        buffer.clear();

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

    }
}
