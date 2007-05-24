package abc.ui.swing.score;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;

import abc.notation.Note;

public class ScoreRenditionContext {
	
	public static final char STAFF_SIX_LINES = '\uF03D';
	public static final char G_CLEF = '\uF026';
	public static final char[] BAR_LINE = {'\uF05C'};
	public static final char[] WHOLE_NOTE = {'\uF092'};
	public static final char[] HALF_NOTE = {'\uF068'};
	public static final char[] QUARTER_NOTE = {'\uF071'};
	public static final char[] EIGHTH_NOTE = {'\uF065'};
	public static final char[] SIXTEENTH_NOTE = {'\uF072'};
	public static final char[] THIRTY_SECOND_NOTE = {'\uF078'};
	
	public static final char[] DOT = {'\uF06B'};
	
	public static final char[] NUMBER_1 = {'\uF031'};
	public static final char[] NUMBER_4 = {'\uF034'};
	public static final char[] NUMBER_6 = {'\uF036'};
	public static final char[] NUMBER_8 = {'\uF038'};
	
	public static final char[] STROKE = {'\uF05F'};
	
	public static final char[] NOTE = {'\uF0CF'};
	
	public static final char STEM_COMBINE_UP_SINGLE = '\uF021';
	public static final char STEM_COMBINE_UP_DOUBLE = '\uF040';
	
	public static final char[] SHARP = {'\uF023'};
	public static final char[] FLAT = {'\uF062'};
	public static final char[] NATURAL = {'\uF06E'};
	public static final float DEFAULT_SIZE = 150;

	private double noteHeigth = -1;
	private double noteWidth = -1;
	private double staffCharWidth = -1;
	private Graphics2D graphics2D = null;
	private Font myFont = null; 
	private Rectangle2D sharpBounds = null;
	private Rectangle2D naturalBounds = null;
	private Rectangle2D flatBounds = null;
	private Rectangle2D quarterNoteBounds = null;
	private BasicStroke notesLinkStroke = null; 
	private BasicStroke stemStroke = null;
	private int noteStrokeLength = -1;
	private int stemLength = -1;
	private int notesSpacing = -1;
	
	public ScoreRenditionContext(Graphics2D g2) {
		try {
			  FontRenderContext frc = g2.getFontRenderContext();
			  File file =new File("D:/Perso/musicfonts/MIDIDESI/TRUETYPE/SONORA.TTF");
			  FileInputStream fontStream = new FileInputStream(file);
			  myFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
			  myFont = myFont.deriveFont(DEFAULT_SIZE);
			  Rectangle2D staffCharBounds = new TextLayout(new Character(STAFF_SIX_LINES).toString(), myFont, frc).getBounds();
			  noteHeigth = staffCharBounds.getHeight()/4.1;
			  staffCharWidth = staffCharBounds.getWidth();
			  sharpBounds = new TextLayout(new Character(SHARP[0]).toString(), myFont, frc).getBounds();
			  flatBounds = new TextLayout(new Character(FLAT[0]).toString(), myFont, frc).getBounds();
			  naturalBounds = new TextLayout(new Character(FLAT[0]).toString(), myFont, frc).getBounds();
			  quarterNoteBounds =  new TextLayout(new Character(QUARTER_NOTE[0]).toString(), myFont, frc).getBounds();
			  noteWidth =  new TextLayout(new Character(NOTE[0]).toString(), myFont, frc).getBounds().getWidth();
			  notesLinkStroke = new BasicStroke((float)(noteWidth/3), 0, 0);
			  stemStroke = new BasicStroke((float)(noteWidth/12));
			  stemLength = (int)(noteHeigth*3);
			  noteStrokeLength = 2;
			  notesSpacing = (int)(1.5*noteWidth);
			  graphics2D = g2;
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public double getNoteHeigth() {
		return noteHeigth;
	}
	
	public double getNoteStrokeLength() {
		return noteStrokeLength;
	}
	
	public double getNoteWidth() {
		return noteWidth;
	}
	
	public double getNotesSpacing() {
		return notesSpacing;
	}
	
	public BasicStroke getNotesLinkStroke(){
		return notesLinkStroke;
	}
	
	public BasicStroke getStemStroke(){
		return stemStroke;
	}
	
	public int getStemLength(){
		return stemLength;
	}
	
	public Graphics2D getGraphics(){
		return graphics2D;
	}
	
	public Rectangle2D getSharpBounds(){
		return sharpBounds;
	}
	
	public Rectangle2D getNaturalBounds(){
		return naturalBounds;
	}
	
	public Rectangle2D getFlatBounds(){
		return flatBounds;
	}
	
	public Rectangle2D getQuarterNoteBounds(){
		return quarterNoteBounds;
	}
	
	public Font getFont() {
		return myFont;
	}
	
	public double getStaffCharWidth() {
		return staffCharWidth;
	}
}
