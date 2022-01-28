package com.example.expenses.controller;

/*

@WebMvcTest(EmployeesController.class)
public class employeeControllerUnitTest
{

    @MockBean
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException
    {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    //Unit Tests for GET, POST starts

    @Test
    @SneakyThrows
    public void getEmployeesUnitTest()
    {

        String uri = "/api/v1/employees/";
        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();


        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        assertEquals(200, status);

    }

    @Test
    @SneakyThrows
    public void registerNewEmployeeUnitTest()
    {
        Employee employee = new Employee(1L, "dikshya", "dixya@gmail.com");
        String actualToString = mapToJson(employee);

        String uri = "/api/v1/employees/";
        String inputJson = mapToJson(employee);
        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);
        String content= result.getResponse().getContentAsString();
        System.out.println(content);
        //assertEquals(content,"{\"id\":1,\"name\":\"dikshya\",\"email\":\"dixya@gmail.com\"}");
        assertEquals(content, actualToString);
    }

    @Test
    @SneakyThrows
    public void updateEmailByIdUnitTest()
    {
        String uri = "/api/v1/employees/update/1";
        String inputJson = "acharya@gmail.com";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

    }
}
*/
