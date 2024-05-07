3.1
Yes, the tests might stop working because @BeforeAll runs only once before all the tests, so the Calculator object would be shared across all tests. This could lead to unexpected behavior or failures because each test should start with a fresh Calculator object to avoid interference between tests.
4.1
test1 is marked as Failure while test2 is marked as Error
4.2	
AssertionError
5.1
White-box testing
5.2
4