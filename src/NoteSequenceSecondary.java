/**
 * Layered implementations of secondary methods for {@code NoteSequence}.
 */
public abstract class NoteSequenceSecondary implements NoteSequence {

    /*
     * Common methods (from Object)
     */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < this.length(); i++) {
            Note n = this.noteAt(i);
            result.append("(").append(n.getPitch()).append(",")
                    .append(n.getDuration()).append(")");
            if (i < this.length() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NoteSequence)) {
            return false;
        }
        NoteSequence other = (NoteSequence) obj;
        if (this.length() != other.length()) {
            return false;
        }
        for (int i = 0; i < this.length(); i++) {
            Note a = this.noteAt(i);
            Note b = other.noteAt(i);
            if (a.getPitch() != b.getPitch()
                    || a.getDuration() != b.getDuration()) {
                return false;
            }
        }
        return true;
    }

    /*
     * Other non-kernel methods
     */

    @Override
    public void transpose(int semitones) {
        for (int i = 0; i < this.length(); i++) {
            Note n = this.noteAt(i);
            n.setPitch(n.getPitch() + semitones);
        }
    }

    @Override
    public void reverse() {
        int n = this.length();
        for (int i = 0; i < n / 2; i++) {
            Note a = this.noteAt(i);
            Note b = this.noteAt(n - 1 - i);
            this.removeNote(n - 1 - i);
            this.removeNote(i);
            this.addNote(i, b);
            this.addNote(n - 1 - i, a);
        }
    }

    @Override
    public void repeat(int times) {
        assert times >= 0 : "Violation of: times >= 0";
        int originalLength = this.length();
        for (int t = 0; t < times; t++) {
            for (int i = 0; i < originalLength; i++) {
                Note n = this.noteAt(i);
                this.addNote(this.length(), n);
            }
        }
    }

    @Override
    public NoteSequence subSequence(int start, int end) {
        assert 0 <= start && start <= end && end <= this
                .length() : "Violation of: 0 <= start <= end <= length()";
        NoteSequence result = this.newInstance();
        int count = end - start;
        for (int i = 0; i < count; i++) {
            Note n = this.noteAt(start);
            result.addNote(result.length(), n);
            this.removeNote(start);
        }
        return result;
    }

    @Override
    public int totalDuration() {
        int total = 0;
        for (int i = 0; i < this.length(); i++) {
            total += this.noteAt(i).getDuration();
        }
        return total;
    }

    @Override
    public int compareTo(NoteSequence other) {
        int minLength = Math.min(this.length(), other.length());
        for (int i = 0; i < minLength; i++) {
            Note a = this.noteAt(i);
            Note b = other.noteAt(i);
            if (a.getPitch() != b.getPitch()) {
                return a.getPitch() - b.getPitch();
            }
            if (a.getDuration() != b.getDuration()) {
                return a.getDuration() - b.getDuration();
            }
        }
        return this.length() - other.length();
    }
}
