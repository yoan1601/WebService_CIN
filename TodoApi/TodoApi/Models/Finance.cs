using Microsoft.Data.SqlClient;

namespace TodoApi.Models
{
    public class Finance
    {
        public Banque? banque { get; set; }
        public Transaction []? transactions { get; set; }

        public double solde { get; set; }

        public static Finance ConsulteFinance(string idCIN)
        {
            Finance f = new Finance();
            //Banque banque= Banque.ConsulteBanque(idCIN);
            Banque banque = Banque.ConsulteBanque(null, idCIN);
            //Transaction[] lTransactions = Transaction.ConsulteTransactions(idCIN);
            Transaction[] lTransactions = Transaction.ConsulteTransactions(null, idCIN);
            f.banque = banque;
            f.transactions = lTransactions;
            f.solde = Finance.ConsulteSolde(null, idCIN);
            return f;
        }

        public static double ConsulteSolde(SqlConnection? connect, string CIN)
        {
            bool isOpened = false;
            if (connect == null)
            {
                string connetionString = @"Server = localhost; Database = cin_banque; Trusted_Connection = True; Encrypt=False";
                connect = new SqlConnection(connet­ionString);
                isOpened = true;
            }

            string query = @"select * from v_transaction_solde where idCINTransaction= '" + CIN + "'";
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

                    double solde = Convert.ToDouble(dr.GetDecimal(dr.GetOrdinal("solde"))); // Convertir Decimal en Double
                    return solde;
                }
                
                return -1;
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
    }
}
