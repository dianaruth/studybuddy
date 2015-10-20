package studybuddy;

public interface Subject {
    public void registerObserver(Student observer);
    public void removeObserver(Student observer);
    public void notifyObservers(String message);
}
