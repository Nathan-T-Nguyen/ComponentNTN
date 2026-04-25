public class LoopDurationUseCase {
    /*
     * When writing sheet music, sometimes things like codas, multiple endings,
     * and repeats are present in the music. Say you are in a marching band
     * having to repeat a certain song multiple times. By using NoteSequence you
     * can calculate how many times and how long you will be plating with each
     * loop.
     */
    public static void main(String[] args) {
        NoteSequence loop = new NoteSequence1L();
        loop.addNote(0, new NoteSequenceKernel.Note(65, 2));
        loop.addNote(1, new NoteSequenceKernel.Note(67, 2));
        loop.repeat(3);
        System.out.println("Loop duration: " + loop.totalDuration());
    }
}
