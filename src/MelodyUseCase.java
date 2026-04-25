public class MelodyUseCase {
    /*
     * Shows building sheet music and transposing it using NoteSequence
     */
    public static void main(String[] args) {
        NoteSequence melody = new NoteSequence1L();
        melody.addNote(0, new NoteSequenceKernel.Note(60, 1));
        melody.addNote(1, new NoteSequenceKernel.Note(62, 1));
        melody.addNote(2, new NoteSequenceKernel.Note(64, 1));
        melody.transpose(2);
        System.out.println(melody);
    }

}
