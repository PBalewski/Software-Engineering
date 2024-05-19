package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import org.mockito.Mockito;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    public void loadExpenses() {
        IFancyDatabase mockDatabase = Mockito.mock(IFancyDatabase.class);
        when(mockDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository expenseRepository = new ExpenseRepository(mockDatabase);
        expenseRepository.loadExpenses();
        InOrder inOrder = inOrder(mockDatabase);
        inOrder.verify(mockDatabase).connect();
        inOrder.verify(mockDatabase).queryAll();
        inOrder.verify(mockDatabase).close();
        assertTrue(expenseRepository.getExpenses().isEmpty());
    }

    @Test
    public void saveExpenses() {
        IFancyDatabase mockDatabase = Mockito.mock(IFancyDatabase.class);
        when(mockDatabase.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository expenseRepository = new ExpenseRepository(mockDatabase);
        for (int i = 0; i < 5; i++) {
            expenseRepository.addExpense(new Expense());
        }
        expenseRepository.saveExpenses();
        InOrder inOrder = inOrder(mockDatabase);
        inOrder.verify(mockDatabase, times(5)).persist(Mockito.any(Expense.class));
    }

}
