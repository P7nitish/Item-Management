# Item-Management


    classDiagram
    InventoryManagementSystem --> JFrame
    InventoryManagementSystem --> DefaultTableModel
    InventoryManagementSystem --> JTable
    class InventoryManagementSystem{
        -frame: JFrame
        -tableModel: DefaultTableModel
        -table: JTable
        -totalValueLabel: JLabel
        +main()
        +createAndShow()
        +addItem()
        +deleteSelected()
        +recalcTotal()
    }
✨ Features
📦 Simple Inventory Tracking - Add, view and delete products

💰 Automatic Value Calculation - Real-time total inventory value

✅ Input Validation - Prevents invalid data entry

🗂️ Tabular Display - Clean, organized view of all items

🖥️ Standalone Application - No database required

🛠️ How to Use
Add Items:

Click "Add Item" button

Enter product details (Name, Code, Price, Quantity)

System automatically calculates line total

Delete Items:

Select row in table

Click "Delete Selected"

View Inventory:

All items displayed in sortable table

Total value shown at bottom
