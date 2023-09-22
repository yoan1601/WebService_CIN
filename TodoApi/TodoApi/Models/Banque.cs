using Microsoft.AspNetCore.Mvc.RazorPages;

namespace TodoApi.Models
{
    public class Banque
    {
        public string? idBanque;
        public string? idCINBanque { get; set; }
        public String? descriptionBanque { get; set; }

        public static Banque ConsulteBanque(string idBanque)
        {
            return new Banque { idBanque = "1" , descriptionBanque = "Banque Paribas", idCINBanque = "123456"};
        }
    }
}
