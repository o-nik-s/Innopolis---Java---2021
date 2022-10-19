public class Main {

    public static void main(String[] args) {

	    WordsRepository wordsRepository = new WordsRepository();

	    Nullable<String> nullableWord = wordsRepository.findWordByCharacter('x');

	    if (nullableWord.isPresent()) {
	        String word = nullableWord.get();
            System.out.println(word.indexOf('x'));
        } else {
            System.err.println("Нет такого слова");
        }

	    UsersRepository usersRepository = new UsersRepository();

	    Nullable<User> nullableUser = usersRepository.findUserByName("Виктор");

	    if (nullableUser.isPresent()) {
	        User user = nullableUser.get();
            System.out.println(user.getAge());
        }

    }
}
