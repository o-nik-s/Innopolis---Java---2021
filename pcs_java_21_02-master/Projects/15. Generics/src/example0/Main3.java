package example0;

public class Main3 {

    public static void main(String[] args) {
	    CoverByGenerics<Nokia3310> nokiaCover = new CoverByGenerics<>();
        CoverByGenerics<iPhone> iPhoneCover = new CoverByGenerics<>();
        Nokia3310 nokia3310 = new Nokia3310();
        iPhone iPhone = new iPhone();

        nokiaCover.setPhone(nokia3310);
        iPhoneCover.setPhone(iPhone);
//        nokiaCover.setPhone(iPhone);
//        iPhoneCover.setPhone(nokia3310);

        Nokia3310 nokiaFromCover = nokiaCover.getPhone();
        nokiaFromCover.call();

        iPhone iPhoneFromCover = iPhoneCover.getPhone();
        iPhoneFromCover.createPhoto();

//        iPhoneFromCover = nokiaCover.getPhone();
    }
}
