package Views;

import Presenter.ShoppingListPresenter;

import java.util.Scanner;

public class ConsoleShoppingListView implements ShoppingListView {

    private ShoppingListPresenter presenter;
    private Scanner scanner;
    private ConsoleItemView itemView;


    public ConsoleShoppingListView(ShoppingListPresenter presenter) {
        this.presenter = presenter;
    }

    public void run() {
        boolean shouldRun = true;
        scanner = new Scanner(System.in);
        while (shouldRun) {
            ConsoleUtils.clearConsole();
            displayShoppingLists();
            ConsoleUtils.displayDivider();
            displayMainMenu();
            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        createShoppingList();
                        break;
                    case 2:
                        modifyShoppingList();
                        break;
                    case 3:
                        deleteShoppingList();
                        break;
                    case 4:
                        manageShoppingListContents();
                        break;
                    default:
                        shouldRun = false;
                }
            }
            catch (NumberFormatException ex){
                shouldRun = false;
            }
        }
        scanner.close();
    }




    private void displayShoppingLists() {
        System.out.println(String.format("%-4s %10s %20s", "ID", "Name", "Description"));
        presenter.getAllShoppingLists();
    }

    private void deleteShoppingList() {
        try {
            System.out.println("Enter the list identifier");
            long shoppingListId = Long.parseLong(scanner.nextLine());
            presenter.deleteShoppingList(shoppingListId);
        }
        catch (NumberFormatException ex){
            System.out.println("Input is not an integer");
            scanner.nextLine();
        }
    }


    private void createShoppingList() {
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();
        presenter.createShoppingList(name, description);

    }

    private void manageShoppingListContents() {
        System.out.println("Choose a list identifier to manage its contents");
        try {
            long shoppingListId = Long.parseLong(scanner.nextLine());
            presenter.manageShoppingListContents(shoppingListId);
        }
        catch (NumberFormatException ex){
            System.out.println("Input is not an integer");
            scanner.nextLine();
        }
    }




    private void modifyShoppingList() {
        try {
            System.out.println("Enter the list identifier");
            long shoppingListId = Long.parseLong(scanner.nextLine());
            System.out.println("New name: ");
            String name = scanner.nextLine();
            System.out.println("New description");
            String description = scanner.nextLine();
            presenter.modifyShoppingList(shoppingListId, name, description);
        }
        catch (NumberFormatException ex){
            System.out.println("Input is not an integer");
            scanner.nextLine();
        }

    }



    private void displayMainMenu() {
        System.out.println("Choose 1 to add a new shopping list");
        System.out.println("Choose 2 to modify list's name and description");
        System.out.println("Choose 3 to remove shopping list");
        System.out.println("Choose 4 to display shopping list's contents");
        System.out.println("Choose any other key to exit");
    }



    @Override
    public void displayCreateErrorMessage() {
        System.out.println("List creation error");
        scanner.nextLine();
    }



    @Override
    public void displayModifyErrorMessage() {
        System.out.println("List modification error");
        scanner.nextLine();
    }


    @Override
    public void displayDeleteErrorMessage() {
        System.out.println("List deletion error");
        scanner.nextLine();
    }

    @Override
    public void displayShoppingList(long id, String name, String description) {
        System.out.println(String.format("%-4d %10s %20s", id, name, description));
    }

    @Override
    public void displayShoppingListNotFoundError() {
        System.out.println("No such shopping list exist");
        scanner.nextLine();
    }

    @Override
    public void openItemView(long shoppingListId) {
        itemView.run(shoppingListId);
    }


    public void setItemView(ConsoleItemView itemView) {
        this.itemView = itemView;
    }
}
