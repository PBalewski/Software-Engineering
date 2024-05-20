package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    public void calculateTotal() {
        ExpenseRepository mockObject = Mockito.mock(ExpenseRepository.class);

        Expense exp1 = new Expense();
        exp1.setAmount(10);

        Expense exp2 = new Expense();
        exp2.setAmount(20);

        Expense exp3 = new Expense();
        exp3.setAmount(30);

        List<Expense> mockExpenses = Arrays.asList(exp1, exp2, exp3);
        when(mockObject.getExpenses()).thenReturn(mockExpenses);

        ExpenseManager expenseManager = new ExpenseManager(mockObject, new FancyService());
        long sum = expenseManager.calculateTotal();
        assertEquals(60, sum);
    }

    @Test
    public void calculateTotalForCategory() {
        ExpenseRepository mockObject = Mockito.mock(ExpenseRepository.class);

        Expense expense1 = new Expense();
        expense1.setCategory("Home");
        expense1.setAmount(50);

        Expense expense2 = new Expense();
        expense2.setCategory("Car");
        expense2.setAmount(100);

        Expense expense3 = new Expense();
        expense3.setCategory("Holiday");
        expense3.setAmount(30);

        mockObject.addExpense(expense1);
        mockObject.addExpense(expense2);
        mockObject.addExpense(expense3);

        when(mockObject.getExpensesByCategory(eq("Home"))).thenReturn(Arrays.asList(expense1));
        when(mockObject.getExpensesByCategory(eq("Car"))).thenReturn(Arrays.asList(expense2));
        when(mockObject.getExpensesByCategory(and(not(eq("Home")), not(eq("Car"))))).thenReturn(new ArrayList<>());

        ExpenseManager expenseManager = new ExpenseManager(mockObject, new FancyService());

        long totalForHome = expenseManager.calculateTotalForCategory("Home");
        long totalForCar = expenseManager.calculateTotalForCategory("Car");
        long totalForOther = expenseManager.calculateTotalForCategory("Holiday");

        assertEquals(50, totalForHome);
        assertEquals(100, totalForCar);
        assertEquals(0, totalForOther);
    }

    @Test
    public void testCalculateTotalInDollars() throws ConnectException {
        ExpenseRepository mockObject = Mockito.mock(ExpenseRepository.class);
        FancyService mockFS = Mockito.mock(FancyService.class);

        Expense exp1 = new Expense();
        exp1.setAmount(10);

        Expense exp2 = new Expense();
        exp2.setAmount(20);

        Expense exp3 = new Expense();
        exp3.setAmount(30);

        List<Expense> mockExpenses = Arrays.asList(exp1, exp2, exp3);
        when(mockObject.getExpenses()).thenReturn(mockExpenses);

        when(mockFS.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(invocation -> {
            double amount = invocation.getArgument(0);
            return amount / 4;
        });

        ExpenseManager expManager = new ExpenseManager(mockObject, mockFS);
        assertTrue(expManager.calculateTotal() == 60);
        assertTrue(expManager.calculateTotalInDollars() == 15);
    }
}
