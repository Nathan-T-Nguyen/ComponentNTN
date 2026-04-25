import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class NoteSequenceTest {

    @Test
    public void testTranspose() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));
        seq.transpose(2);
        assertEquals(62, seq.noteAt(0).getPitch());
    }

    @Test
    public void testReverse() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));
        seq.addNote(1, new NoteSequenceKernel.Note(62, 1));
        seq.reverse();
        assertEquals(62, seq.noteAt(0).getPitch());
        assertEquals(60, seq.noteAt(1).getPitch());
    }

    @Test
    public void testRepeat() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));
        seq.repeat(2);
        assertEquals(3, seq.length());
    }

    @Test
    public void testSubSequence() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));
        seq.addNote(1, new NoteSequenceKernel.Note(62, 1));
        seq.addNote(2, new NoteSequenceKernel.Note(64, 1));
        NoteSequence sub = seq.subSequence(1, 3);
        assertEquals(1, seq.length());
        assertEquals(2, sub.length());
        assertEquals(62, sub.noteAt(0).getPitch());
    }

    @Test
    public void testTotalDuration() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 2));
        seq.addNote(1, new NoteSequenceKernel.Note(62, 3));
        assertEquals(5, seq.totalDuration());
    }

    @Test
    public void testEqualsTrue() {
        NoteSequence a = new NoteSequence1L();
        NoteSequence b = new NoteSequence1L();
        a.addNote(0, new NoteSequenceKernel.Note(60, 1));
        b.addNote(0, new NoteSequenceKernel.Note(60, 1));
        assertEquals(a, b);
    }

    @Test
    public void testEqualsFalse() {
        NoteSequence a = new NoteSequence1L();
        NoteSequence b = new NoteSequence1L();
        a.addNote(0, new NoteSequenceKernel.Note(60, 1));
        b.addNote(0, new NoteSequenceKernel.Note(62, 1));
        assertNotEquals(a, b);
    }

    @Test
    public void testToStringNotNull() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));
        assertNotNull(seq.toString());
    }
}