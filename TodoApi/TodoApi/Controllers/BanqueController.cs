using Microsoft.AspNetCore.Mvc;
using TodoApi.Models;

[Route("api/[controller]")]
[ApiController]
public class BanqueController : ControllerBase
{
    [HttpGet("consultationBanque")]
    public IActionResult ConsulteFinance(string idCIN)
    {
        Finance finance = Finance.ConsulteFinance(idCIN);
        //int i = 12;
        //Console.WriteLine(finance);
        return Ok(finance);
    }
}