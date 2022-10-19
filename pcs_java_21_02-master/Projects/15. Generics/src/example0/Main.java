package example0;

public class Main {

    public static void main(String[] args) {
	    CoverByObject cover = new CoverByObject();
        Nokia3310 nokia3310 = new Nokia3310();
        iPhone iPhone = new iPhone();

        cover.setPhone(nokia3310);

        Nokia3310 nokiaFromCover = (Nokia3310) cover.getPhone();
        nokiaFromCover.call();

        cover.setPhone(iPhone);

        iPhone iPhoneFromCover = (iPhone) cover.getPhone();

        iPhoneFromCover.createPhoto();
    }
}
