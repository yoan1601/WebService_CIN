using Microsoft.AspNetCore.Mvc;
using TodoApi.Models;

[Route("api/[controller]")]
[ApiController]
public class CalculatorController : ControllerBase
{
    [HttpGet("add")]
    public IActionResult Add(int num1, int num2)
    {
        int result = num1 + num2;
        return Ok(result);
    }
}