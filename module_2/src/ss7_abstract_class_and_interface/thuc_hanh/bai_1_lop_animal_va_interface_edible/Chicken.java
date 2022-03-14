package ss7_abstract_class_and_interface.thuc_hanh.bai_1_lop_animal_va_interface_edible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
