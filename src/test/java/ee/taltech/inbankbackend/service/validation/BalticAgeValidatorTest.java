@SpringBootTest
class BalticAgeValidatorTest {
    @Autowired
    private BalticProperties properties;
    
    @Test
    void validateEstonianAge_Success() {
        AgeValidator validator = new EstonianAgeValidator(properties);
        ValidationResponse response = validator.validateAge("39703130245");
        assertTrue(response.isValid());
        assertEquals("EE", response.getCountryCode());
    }
    
    @Test
    void validateEstonianAge_Underage() {
        AgeValidator validator = new EstonianAgeValidator(properties);
        ValidationResponse response = validator.validateAge("60804130245");
        assertFalse(response.isValid());
        assertEquals(ErrorMessages.UNDERAGE, response.getMessage());
    }
}