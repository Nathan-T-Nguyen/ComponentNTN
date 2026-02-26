public class NoteSequence {
    private static class Note {
        private int pitch; // MIDI integer pitch
        private int duration; // Length in # of beats

        public Note(int pitch, int duration) {
            this.pitch = pitch;
            this.duration = duration;
        }

        public int getPitch() {
            return this.pitch;
        }

        public void setPitch(int pitch) {
            this.pitch = pitch;
        }

        public int getDuration() {
            return this.duration;
        }

        @Override
        public String toString() {
            return "(" + this.pitch + ", " + this.duration + ")";
        }
    }
}
