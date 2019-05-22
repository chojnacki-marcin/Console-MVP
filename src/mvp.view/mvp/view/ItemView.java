package mvp.view;

public interface ItemView {
    void displayCreateErrorMessage();

    void displayModifyErrorMessage();

    void displayDeleteErrorMessage();

    void displayItem(long id, String name);
}
