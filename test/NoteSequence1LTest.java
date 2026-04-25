import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class NoteSequence1LTest {

    @Test
    public void testConstructor() {
        NoteSequence seq = new NoteSequence1L();
        assertEquals(0, seq.length());
    }

    @Test
    public void testAddNote() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));

        assertEquals(1, seq.length());
        assertEquals(60, seq.noteAt(0).getPitch());
    }

    @Test
    public void testRemoveNote() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));
        seq.removeNote(0);
        assertEquals(0, seq.length());
    }

    @Test
    public void testNoteAtDoesNotModify() {
        NoteSequence seq = new NoteSequence1L();
        NoteSequenceKernel.Note n = new NoteSequenceKernel.Note(60, 1);
        seq.addNote(0, n);
        NoteSequenceKernel.Note result = seq.noteAt(0);
        assertEquals(60, result.getPitch());
        assertEquals(1, seq.length()); // still unchanged
    }

    @Test
    public void testLengthMultipleNotes() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));
        seq.addNote(1, new NoteSequenceKernel.Note(62, 2));
        seq.addNote(2, new NoteSequenceKernel.Note(64, 3));
        assertEquals(3, seq.length());
    }

    @Test
    public void testClear() {
        NoteSequence seq = new NoteSequence1L();
        seq.addNote(0, new NoteSequenceKernel.Note(60, 1));
        seq.clear();
        assertEquals(0, seq.length());
    }

    @Test
    public void testNewInstance() {
        NoteSequence seq = new NoteSequence1L();
        NoteSequence newSeq = seq.newInstance();
        assertEquals(0, newSeq.length());
        assertNotSame(seq, newSeq);
    }

    @Test
    public void testTransferFrom() {
        NoteSequence seq1 = new NoteSequence1L();
        NoteSequence seq2 = new NoteSequence1L();
        seq1.addNote(0, new NoteSequenceKernel.Note(60, 1));
        seq2.transferFrom(seq1);
        assertEquals(1, seq2.length());
        assertEquals(0, seq1.length());
    }
}
