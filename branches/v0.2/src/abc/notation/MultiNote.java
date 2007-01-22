package abc.notation;

import java.util.Vector;
/** A multi note is a group of notes that should be played together. */
public class MultiNote extends NoteAbstract
{
  /** Notes contained in this multinote. */
  private Vector m_notes;

  /** Creates a new <TT>MultiNote</TT> from given notes.
   * @param notes A Vector containing the <TT>NoteAbstract</TT> of this
   * <TT>MultiNote</TT>. */
  public MultiNote (Vector notes)
  {
    super();
    m_notes = notes;
  }

  /** Returns the longest note of this multi note.
   * @return The longest note of this multi note. If several notes have the
   * same longest length, the first one is returned. */
  public Note getLongestNote()
  {
    float length = 0;
    float currentNoteLength = 0;
    Note maxNote = null;
    for (int i=0; i<m_notes.size() && maxNote==null; i++)
    {
      currentNoteLength = ((Note)(m_notes.elementAt(i))).getDuration();
      if (currentNoteLength > length)
        maxNote = (Note)m_notes.elementAt(i);
    }
    return maxNote;
  }

  /** Returns a new vector containing all <TT>Note</TT> objects contained in
   * this multi note.
   * @return a new vector containing all <TT>Note</TT> objects contained in
   * this multi note. */
  public Vector getNotesAsVector()
  { return (Vector)m_notes.clone(); }
}