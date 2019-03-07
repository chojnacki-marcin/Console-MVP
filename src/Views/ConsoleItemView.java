package Views;

import Presenter.ItemPresenter;

import java.util.Scanner;

public class ConsoleItemView implements ItemView {

    private final ItemPresenter presenter;
    private final Scanner scanner;

    ConsoleItemView(ItemPresenter presenter) {
        this.presenter = presenter;
        scanner = new Scanner(System.in);
    }

    void run(long shoppingListId){
        boolean shouldRun = true;
        while (shouldRun) {
            ConsoleUtils.clearConsole();
            displayItems(shoppingListId);
            ConsoleUtils.displayDivider();
            displayItemMenu();
            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        addItem(shoppingListId);
                        break;
                    case 2:
                        modifyItem();
                        break;
                    case 3:
                        deleteItem();
                        break;
                    default:
                        shouldRun = false;
                }
            }
            catch (NumberFormatException ex){
                shouldRun = false;
            }
        }
    }

    private void displayItems(long shoppingListId) {
        System.out.println(String.format("%4s %10s", "ID", "Name"));
        presenter.getItems(shoppingListId);
    }

    private void displayItemMenu() {
        System.out.println("Choose 1 to add an item.");
        System.out.println("Choose 2 to update an item");
        System.out.println("Choose 3 aby remove an item");
        System.out.println("Choose any key to return to main menu");
    }

    private void deleteItem() {
        System.out.println("Enter the item identifier");
        try {
            long itemId = Long.parseLong(scanner.nextLine());
            presenter.deleteItem(itemId);
        }
        catch (NumberFormatException ex){
            System.out.println("Input is not an integer");
        }

    }

    private void modifyItem() {
        System.out.println("Enter the item identifier");
        try {
            long itemId = Long.parseLong(scanner.nextLine());
            System.out.println("Enter the new product name");
            String name = scanner.nextLine();
            presenter.modifyItem(itemId, name);
        }
        catch (NumberFormatException ex){
            System.out.println("Input is not an integer");
        }
    }

    private void addItem(long shoppingListId) {
        System.out.println("Enter the product name");
        String name = scanner.nextLine();
        presenter.addItem(name, shoppingListId);
    }

    @Override
    public void displayItem(long id, String name) {
        System.out.println(String.format("%-4d %10s", id, name));
    }

    @Override
    public void displayCreateErrorMessage() {
        System.out.println("Item creation error");
    }

    @Override
    public void displayModifyErrorMessage() {
        System.out.println("Item modification error");
    }

    @Override
    public void displayDeleteErrorMessage() {
        System.out.println("Item deletion error");
    }
}
