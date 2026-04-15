import java.util.ArrayList;

/**
 * {@code NoteSequence} represented as an {@code ArrayList<Note>}.
 * 
 * @convention <pre>
 * notes is not null AND all elements of notes are not null AND
 * for all Note n in notes, n.getDuration() >= 0 </pre>
 * @correspondence <pre>
 * this represents a sequence of Notes such that:
 * the note at index i in notes corresponds to the note at position i
 * in the abstract sequence </pre>
 */
public class NoteSequence1L extends NoteSequenceSecondary {
    /*
     * Representation
     */
    private ArrayList<Note> notes;

    /*
     * Creator of initial representation
     */
    private void createNewRep() {
        this.notes = new ArrayList<>();
    }

    /**
     * No-argument constructor.
     */
    public NoteSequence1L() {
        this.createNewRep();
    }

    /*
     * Standard methods
     */
    @Override
    public final NoteSequence newInstance() {
        return new NoteSequence1L();
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(NoteSequence source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        NoteSequence1L localSource = (NoteSequence1L) source;
        this.notes = localSource.notes;
        localSource.createNewRep();
    }

    /*
     * Kernel methods
     */

    @Override
    public final void addNote(int position, Note n) {
        assert n != null : "Violation of: n is not null";
        assert 0 <= position && position <= this
                .length() : "Violation of: 0 <= position <= length()";

        this.notes.add(position, n);
    }

    @Override
    public final void removeNote(int position) {
        assert 0 <= position && position < this
                .length() : "Violation of: 0 <= position < length()";

        this.notes.remove(position);
    }

    @Override
    public final Note noteAt(int position) {
        assert 0 <= position && position < this
                .length() : "Violation of: 0 <= position < length()";

        return this.notes.get(position);
    }

    @Override
    public final int length() {
        return this.notes.size();
    }
}
