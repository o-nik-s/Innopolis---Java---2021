package object;

/**
 * 07.11.2021
 * 14. Object and String
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human {
    private int age;
    private boolean isWorker;

    public Human(int age, boolean isWorker) {
        this.age = age;
        this.isWorker = isWorker;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human(age = " + age + ", " + isWorker + ")";
    }

    @Override
    public boolean equals(Object obj) {
        // если мы сравниваем объект с самим собой
        if (this == obj) {
            // сразу возвращаем true
            return true;
        }

        // к нам пришел Object, а вдруг там вообще не Human?
        if (!(obj instanceof Human)) {
            return false;
        }

        // теперь мы точно знаем, что это другой объект и при этом он точно Human
        // делаем явное преобразование
        Human that = (Human)obj;

        // сравниваем интересующие нас поля
        return this.age == that.age && this.isWorker == that.isWorker;
    }
}
