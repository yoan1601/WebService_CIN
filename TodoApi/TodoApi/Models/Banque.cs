using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Data.SqlClient;

namespace TodoApi.Models
{
    public class Banque
    {
        public string? idBanque;
        public string? idCINBanque { get; set; }
        public String? descriptionBanque { get; set; }

        public static Banque ConsulteBanque(SqlConnection? connect, string CIN)
        {
            bool isOpened = false;
            if (connect == null)
            {
                string connetionString = @"Server = localhost; Database = cin_banque; Trusted_Connection = True; Encrypt=False";
                connect = new SqlConnection(connet­ionString);
                isOpened = true;
            }

            string query = @"select * from banques where idCINBanque = '" + CIN + "'";
            //define the SqlCommand object
            SqlCommand cmd = new(query, connect);
            connect.Open();
            //execute the SQLCommand
            SqlDataReader dr = cmd.ExecuteReader();
            try
            {
                //check if there are records
                if (dr.HasRows)
                {
                    dr.Read();

                    Banque banque = new Banque { 
                        idBanque = dr["idBanque"].ToString(),
                        idCINBanque = dr["idCINBanque"].ToString(),
                        descriptionBanque = dr["descriptionBanque"].ToString()
                    };
                    return banque;
                }

                return new Banque();
            }
            finally
            {
                //close data reader
                dr.Close();
                if (isOpened)
                {
                    connect.Close();
                }
            }
        }

        public static Banque ConsulteBanque(string idBanque)
        {
            return new Banque { idBanque = "1" , descriptionBanque = "Banque Paribas", idCINBanque = "123456"};
        }
    }
}
