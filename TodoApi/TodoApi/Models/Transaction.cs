using Microsoft.Data.SqlClient;
using System.Reflection.PortableExecutable;

namespace TodoApi.Models
{
    public class Transaction
    {
        public string? idTransaction { get; set; }
        public string? nomBanque { get; set; }
        public string? idCINTransaction { get; set; }
        public string? descriptionTransaction { get; set; }
        public double? depot { get; set; }
        public double? retrait { get; set; }
        public string? dateHeureTransaction { get; set; }

        public static Transaction[] ConsulteTransactions(SqlConnection? connect, string CIN)
        {
            bool isOpened = false;
            if (connect == null) {
                string connetionString = @"Server = localhost; Database = cin_banque; Trusted_Connection = True; Encrypt=False";
                connect = new SqlConnection(connet­ionString);
                isOpened = true;
            }
            
            string query = @"select * from transactions where idCINTransaction= '" + CIN + "' ORDER BY dateHeureTransaction DESC";
            //define the SqlCommand object
            SqlCommand cmd = new SqlCommand(query, connect);
            connect.Open();
            //execute the SQLCommand
            SqlDataReader dr = cmd.ExecuteReader();
            try
            {
                List<Transaction> liste = new List<Transaction>();
                //check if there are records
                if (dr.HasRows)
                {
                    while (dr.Read())
                    {
                        Transaction transaction = new Transaction {
                            idTransaction = dr["idTransaction"].ToString(),
                            nomBanque = dr["nomBanque"].ToString(),
                            idCINTransaction = dr["idCINTransaction"].ToString(),
                            descriptionTransaction = dr["descriptionTransaction"].ToString(),
                            depot = Convert.ToDouble(dr.GetDecimal(dr.GetOrdinal("depot"))), // Convertir Decimal en Double
                            retrait = Convert.ToDouble(dr.GetDecimal(dr.GetOrdinal("retrait"))), // Convertir Decimal en Double
                            dateHeureTransaction = dr["dateHeureTransaction"].ToString()
                        };
                        liste.Add(transaction);
                    }
                } else { 
                    return new Transaction[0]; 
                }





                Transaction[] transactions = new Transaction[liste.Count];
                 for (int i = 0; i < transactions.Length; i++)
                 {
                     transactions[i] = liste[i];
                 }
                 return transactions;
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

        public static Transaction[] ConsulteTransactions(string idCIN)
        {
            Transaction t1 = new Transaction { 
                idTransaction = "1",
                nomBanque = "BNI MDG",
                depot = 0,
                retrait = 800,
                dateHeureTransaction = "16/01/2003 10:00:00"};

            Transaction t2 = new Transaction
            {
                idTransaction = "2",
                nomBanque = "ENJANA",
                depot = 2050,
                retrait = 0,
                dateHeureTransaction = "17/01/2003 10:00:00"
            };

            Transaction t3 = new Transaction
            {
                idTransaction = "3",
                nomBanque = "BOA MDG",
                depot = 0,
                retrait = 20000,
                dateHeureTransaction = "16/01/2003 10:00:00"
            };

            Transaction[] transactions = { t1, t2, t3 };
            return transactions;
        }
    }
}
