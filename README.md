<div align="center">

# PBA (Problem-Based Assignment)
### *A High-Performance Agricultural Data Analytics & Management System*

[![GitHub License](https://img.shields.io/github/license/Sumit444-commits/PBA?style=for-the-badge)](https://github.com/Sumit444-commits/PBA)
[![Java Version](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)

**PBA** is a robust Java-based analytical engine designed to process, manage, and query large-scale crop production datasets. Developed as a 3rd-semester Problem-Based Learning (PBL) project, it combines custom data structures with SQL persistence to deliver efficient insights into agricultural trends across various states.

</div>

---


## 🚀 Key Features

*   **Custom Data Structure Implementation:** Utilizes high-performance, manually implemented `LinkedList` and `Queue` structures for optimized memory management and data traversal.
*   **Relational Database Integration:** Seamless connectivity via a dedicated `DB` module to manage persistent storage using SQL.
*   **Large-Scale Data Ingestion:** Capable of parsing and processing extensive `crop_production.csv` datasets for real-time analysis.
*   **Multi-Entity Modeling:** Sophisticated object-oriented modeling for `Crop` and `State` entities, allowing for granular data manipulation.
*   **Advanced Query Engine:** A specialized `Querry` (Query) module designed to execute complex search and filter operations across the agricultural dataset.
*   **State-wise Analytics:** Aggregates and organizes data based on geographical boundaries for regional production insights.

---

## 🛠 Technology Stack

| Category | Technology |
| :--- | :--- |
| **Language** | Java (JDK 8+) |
| **Database** | SQL (MySQL Recommended) |
| **Data Format** | CSV (Comma Separated Values) |
| **Architecture** | Custom Data Structures (Nodes, Linked Lists, Queues) |

---

## 📂 Directory Structure

```text
.
├── MyPBL/
│   ├── src/
│   │   └── myPackage/
│   │       ├── Crop.java          # Model representing crop attributes
│   │       ├── DB.java            # Database connection and CRUD logic
│   │       ├── LinkedList.java    # Custom implementation of a Linked List
│   │       ├── Main.java          # Application entry point
│   │       ├── Node.java          # Basic building block for custom DS
│   │       ├── Querry.java        # Business logic for data searching
│   │       ├── Queue.java         # Custom implementation of a Queue
│   │       └── State.java         # Model representing State-wise data
│   └── bin/                       # Compiled .class files
├── PBLDATABASE.sql                # SQL schema for database initialization
├── crop_production.csv            # Raw dataset for processing
└── README.md                      # Project documentation
```

---

## ⚙️ Getting Started

### Prerequisites
*   **Java Development Kit (JDK):** Version 8 or higher.
*   **MySQL Server:** To host the `PBLDATABASE`.
*   **IDE:** IntelliJ IDEA, Eclipse, or VS Code (with Java Extension Pack).

### Installation & Setup

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Sumit444-commits/PBA.git
    cd PBA
    ```

2.  **Database Configuration:**
    *   Import the `PBLDATABASE.sql` into your local MySQL instance.
    *   Update the credentials in `MyPBL/src/myPackage/DB.java`:
        *   `DB_URL`
        *   `DB_USER`
        *   `DB_PASSWORD`

3.  **Compile the Project:**
    ```bash
    javac MyPBL/src/myPackage/*.java -d MyPBL/bin
    ```

4.  **Run the Application:**
    ```bash
    java -cp MyPBL/bin myPackage.Main
    ```

---

## 👤 Author

**Sumit444-commits**
*   **GitHub:** [View Profile](https://github.com/Sumit444-commits)
*   **Role:** Lead Developer & Architect

---

Designed with ❤️ Autome
