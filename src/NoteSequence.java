//Not sure what to do with package to make a non error.
// If it was a package it would look like:
// package components.notesequence;

/**
 * {@code NoteSequenceKernel} enhanced with secondary methods.
 */
public interface NoteSequence
        extends Comparable<NoteSequence>, NoteSequenceKernel {
    /**
     * Transposes all notes in the sequence by the given number of semitones.
     *
     * @param semitones
     *            number of semitones to shift pitches
     * @updates this
     * @ensures each note's pitch = #each note's pitch + semitones
     */
    void transpose(int semitones);

    /**
     * Reverses the order of the notes in this sequence.
     *
     * @updates this
     * @ensures noteAt(i) = #noteAt(length() - 1 - i) for all 0 <= i < length()
     */
    void reverse();

    /**
     * Repeats the current sequence a given number of times.
     *
     * @param times
     *            number of times to repeat the sequence
     * @updates this
     * @requires times >= 0
     * @ensures length() = #length() * (times + 1)
     */
    void repeat(int times);

    /**
     * Returns a subsequence from start (inclusive) to end (exclusive) indices.
     * The subsequence is removed from this sequence.
     *
     * @param start
     *            index to start the subsequence (inclusive)
     * @param end
     *            index to end the subsequence (exclusive)
     * @return a new NoteSequence containing the subsequence
     * @updates this
     * @requires 0 <= start <= end <= length()
     * @ensures length() = #length() - (end - start)
     */
    NoteSequence subSequence(int start, int end);

    /**
     * Returns the total duration of all notes in this sequence.
     *
     * @return sum of all note durations
     * @ensures totalDuration() = sum of durations of all notes in this
     */
    int totalDuration();
}
