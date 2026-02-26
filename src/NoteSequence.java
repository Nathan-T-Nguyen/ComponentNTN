import java.util.ArrayList;
import java.util.List;

/**
 * Proof-of-concept implementation for NoteSequence. Also, may change the name
 * because I'm using ArrayLists?
 *
 * @author Nathan Nguyen
 */
public class NoteSequence {
    /** Class for a note in sheet music. */
    private static class Note {
        /**
         * MIDI integer pitch.
         */
        private int pitch;
        /**
         * Length in # of beats.
         */
        private int duration;

        /**
         * @param pitch
         * @param duration
         */
        Note(int pitch, int duration) {
            this.pitch = pitch;
            this.duration = duration;
        }

        /**
         * @return pitch
         */
        public int getPitch() {
            return this.pitch;
        }

        /**
         * @param pitch
         */
        public void setPitch(int pitch) {
            this.pitch = pitch;
        }

        /**
         * @return duration
         */
        public int getDuration() {
            return this.duration;
        }

        @Override
        public String toString() {
            return "(" + this.pitch + ", " + this.duration + ")";
        }
    }

    /**
     */
    private List<Note> notes;

    /**
     */
    public NoteSequence() {
        this.notes = new ArrayList<>();
    }

    //Kernels
    /**
     * @param position
     * @param n
     */
    public void addNote(int position, Note n) {
        this.notes.add(position, n);
    }

    /**
     * @param position
     */
    public void removeNote(int position) {
        this.notes.remove(position);
    }

    /**
     * @param position
     * @return the note at position
     */
    public Note noteAt(int position) {
        return this.notes.get(position);
    }

    /**
     * @return length of sequence
     */
    public int length() {
        return this.notes.size();
    }

    /**
     */
    public void clear() {
        this.notes.clear();
    }

    //Secondaries
    /**
     * Changes notes up/down some semitones to fit the instrument wanted. (Or
     * key)
     *
     * @param semitones
     */
    public void transpose(int semitones) {
        for (Note n : this.notes) {
            n.setPitch(n.getPitch() + semitones);
        }
    }

    /**
     */
    public void reverse() {
        List<Note> reversed = new ArrayList<>();
        for (int i = this.notes.size() - 1; i >= 0; i--) {
            reversed.add(this.notes.get(i));
        }
        this.notes = reversed;
    }

    /**
     * @param times
     */
    public void repeat(int times) {
        List<Note> original = new ArrayList<>(this.notes);
        for (int i = 1; i < times; i++) {
            this.notes.addAll(original);
        }
    }

    /**
     * Returns a section of the piece, a bit crude.
     *
     * @param start
     *            index of beggining of subSequence
     * @param end
     *            index of end of wanted subSequence
     * @return The sequence
     */
    public NoteSequence subSequence(int start, int end) {
        NoteSequence sub = new NoteSequence();
        for (int i = start; i < end; i++) {
            sub.addNote(sub.length(), this.notes.get(i));
        }
        return sub;
    }

    /**
     * @return duration of entire sequence
     */
    public int totalDuration() {
        int total = 0;
        for (Note n : this.notes) {
            total += n.getDuration();
        }
        return total;
    }

    /**
     * Is example of the methods.
     *
     * @param args
     */
    public static void main(String[] args) {
        NoteSequence seq = new NoteSequence();
        // Adds C, D, and E, which have duration quarter note 1, 1, and 2 respectively.
        seq.addNote(0, new Note(60, 1));
        seq.addNote(1, new Note(62, 1));
        seq.addNote(2, new Note(64, 2));
        System.out.println("Original sequence:");
        for (int i = 0; i < seq.length(); i++) {
            System.out.println(seq.noteAt(i));
        }
        // Transposes up 2 semitones to make it D, E, and F. These should all be
        // in the middle of the clef.
        seq.transpose(2);
        System.out.println("\nAfter transpose:");
        for (int i = 0; i < seq.length(); i++) {
            System.out.println(seq.noteAt(i));
        }
        System.out.println("\nTotal Duration: " + seq.totalDuration());
    }

}
