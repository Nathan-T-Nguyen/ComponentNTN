
//Not sure what to do with package to make a non error.
// If it was a package it would look like:
// package components.notesequence;
import components.standard.Standard;

/**
 * Kernel interface for a sequence of musical notes. (Note: by package-wide
 * convention, all references are non-null.)
 *
 * @mathsubtypes <pre>
 * NOTE is a musical note with pitch and duration
 * exemplar n
 * CONSTRAINT n.duration >= 0
 * </pre>
 * @mathmodel type NoteSequenceKernel is modeled by SEQ(NOTE)
 * @initially <pre>
 * ():
 *  ensures
 *   length() = 0
 * (Note n):
 * ensures
 * addNote(0, n) then length() = 1
 * </pre>
 */
public interface NoteSequenceKernel extends Standard<NoteSequence> {
    /**
     * Inserts a note at the given position.
     *
     * @param position
     *            index at which to insert the note
     * @param n
     *            the note to insert
     * @updates this
     * @requires 0 <= position <= length()
     * @ensures noteAt(position) = n
     */
    void addNote(int position, Note n);

    /**
     * Removes the note at the given position.
     *
     * @param position
     *            index of the note to remove
     * @updates this
     * @requires 0 <= position < length()
     * @ensures length() = #length() - 1
     */
    void removeNote(int position);

    /**
     * Returns the note at the given position.
     *
     * @param position
     *            index of the note to return
     * @return the note at the specified position
     * @requires 0 <= position < length()
     */
    Note noteAt(int position);

    /**
     * Returns the number of notes in this sequence.
     *
     * @return number of notes
     * @ensures length() >= 0
     */
    int length();

    /**
     * Minimal representation of a musical note for this component. Pitch is an
     * integer (e.g., MIDI number), duration is in arbitrary units.
     */
    class Note {
        /** The pitch of the note (e.g., MIDI number). */
        private int pitch;
        /**
         * The duration of the note in arbitrary unit type. Must be
         * non-negative.
         */
        private int duration;

        /**
         * Constructs a Note with pitch and duration.
         *
         * @param pitch
         *            the pitch of the note
         * @param duration
         *            the duration of the note
         * @requires duration >= 0
         * @ensures this.pitch = pitch and this.duration = duration
         */
        public Note(int pitch, int duration) {
            this.pitch = pitch;
            this.duration = duration;
        }

        /**
         * Returns the pitch of this note.
         *
         * @return the pitch of this note
         */
        public int getPitch() {
            return this.pitch;
        }

        /**
         * Returns the duration of this note.
         *
         * @return the duration of this note
         */
        public int getDuration() {
            return this.duration;
        }

        /**
         * Sets the pitch of this note.
         *
         * @param pitch
         *            the new pitch for this note
         */
        public void setPitch(int pitch) {
            this.pitch = pitch;
        }

        /**
         * Sets the pitch of this note.
         *
         * @param duration
         *            the new duration for this note
         */
        public void setDuration(int duration) {
            this.duration = duration;
        }
    }
}
