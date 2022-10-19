package example0;

public class Main2 {

    public static void main(String[] args) {
	    CoverByObject cover = new CoverByObject();
        Nokia3310 nokia3310 = new Nokia3310();
        iPhone iPhone = new iPhone();

        cover.setPhone(iPhone);

        Nokia3310 nokiaFromCover = (Nokia3310) cover.getPhone();
        nokiaFromCover.call();
    }
}
