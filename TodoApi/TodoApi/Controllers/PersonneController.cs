using Microsoft.AspNetCore.Mvc;
using TodoApi.Models;

[Route("api/[controller]")]
[ApiController]
public class PersonneController : ControllerBase
{
    [HttpGet("getOnePersonne")]
    public IActionResult getOnePersonne()
    {
        Personne personne = new Personne
        {
            idPersonne = 1,
            nom = "jean"
        };
        return Ok(personne);
    }

    [HttpGet("getSomePersonnes")]
    public IActionResult getSomePersonnes()
    {
        Personne personne = new Personne
        {
            idPersonne = 1,
            nom = "jean"
        };
        Personne personne2 = new Personne
        {
            idPersonne = 2,
            nom = "jean2"
        };
        Personne personne3 = new Personne
        {
            idPersonne = 3,
            nom = "jean3"
        };

        Personne [] lp = { personne, personne2, personne3 };
        return Ok(lp);
    }
}