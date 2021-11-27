package Interface;

import javax.swing.*;

public class Places {
/*
Returns a JOption pane with the information of each place according to the String argument
 */
    public static void getInfo(String place){
        String info;
        switch (place){
            case "Quebradilla":
                info =   place+"\n"+"Habitantes: 6025 \n" +
                        "Lugares de Interés:  Cerro La Carpintera, Fossil Land \n" +
                        "Restaurantes: La Rueda, Soda El Cruce del Sabor, Soda Las Flores\n" +
                        "Gasolineras: Gasolinera más cercana en Tejar \n";
                break;
            case "Tejar":
                info =   place+"\n"+ "Habitantes: 24 984\n" +
                        "Lugares de Interés: Parque Central de Tejar, Hotel el Guarco, Salón de Eventos Palo Blanco\n" +
                        "Restaurantes: McDonald’s Tejar, Pops, el Quijongo\n" +
                        "Gasolineras: Servicentro el Guarco\n";

                break;
            case "Cartago":
                info =   place+"\n"+
                        "Habitantes: 160 457\n" +
                        "Lugares de Interés: Ruinas de Cartago, Basílica de los Ángeles, Volcán Irazú\n" +
                        "Restaurantes: Food Court en Mall Paseo Metrópoli, McDonald 's, KFC, Taco Bell y Subway.\n" +
                        "Gasolineras: Delta el Molino, Servicentro Metrópoli, Servicentro La Tica.\n";
                break;
            case "Paraiso":
                info =   place+"\n"+"Habitantes: 20 601\n" +
                        "Lugares de Interés: Parque Recreativo Laguna de Doña Ana, Cabinas Sueños de Maíz\n" +
                        "Restaurantes: Piso de Tierra, Nóno Coffee & Garden\n" +
                        "Gasolineras: Grupo SERPASA SA\n";

                break;
            case "Turrialba":
                info =   place+"\n"+"Habitantes: 69 616\n" +
                        "Lugares de Interés: Volcán Turrialba, Rafting Río Pacuare Museo Omar Salazar Obando\n" +
                        "Restaurantes: Las Carnitas Bar & Rest, Mundo de Sabores, El sabor Turrialbeño\n" +
                        "Gasolineras: Servicentro JSM, Gasolinera Los Orozco\n";
                break;
            case "Ochomogo":
                info =   place+"\n"+"Habitantes: 113 162\n" +
                        "Lugares de Interés:  Estatua Cristo Rey, Parque Ambiental Río Loro, Refinadora Costarricense de Petróleo (RECOPE)\n" +
                        "Restaurantes: Soda y Restaurante El Trailero, Rancho la Angelina, Soda Irazú\n" +
                        "Gasolineras: Servicentro Cristo Rey\n";
                break;
            case "Tres Rios":
                info =   "Tres Ríos"+"\n"+"Habitantes: 9 331\n" +
                        "Lugares de Interés: Terramall, Pricesmart Tres Ríos\n" +
                        "Restaurantes: Taller del Artista, Marisquería Ambos Mares, La Esquina de Pepe\n" +
                        "Gasolineras: ServiIndoor\n";
                break;
            case "Curridabat":
                info =   place+"\n"+"Habitantes: 28 817\n" +
                        "Lugares de Interés: Multiplaza Curridabat, The Train Suites Curridabat Hotel, Ciudad del Este\n" +
                        "Restaurantes: El Balcón del Marisco, Los Parales, Woods Pizza & Beer Garden\n" +
                        "Gasolineras: La Galera, ServiIndoor\n";
                break;
            case "Desamparados":
                info =   place+"\n"+"Habitantes: 33 866\n" +
                        "Lugares de Interés: Multicentro Desamparados Mall, Museo de la Carreta, Complejo de Piscinas Silvia y Claudia Poll\n" +
                        "Restaurantes: Cheesus, Soda Yoguis, Hood Grill, Antologías\n" +
                        "Gasolineras: Delta el Cruce, Bomba San Antonio, UNO\n";
                break;
            case "San Pedro":
                info =   "San Pedro"+"\n"+"Habitantes: 23 997 \n" +
                        "Lugares de Interés: Mall San Pedro, Museo de Insectos, Universidad de Costa Rica. \n" +
                        "Restaurantes: La Parrillita de Pepe, Jürgens, Ristorante L’Ancora Da Ciro & Tony\n" +
                        "Gasolineras: Bomba San Pedro\n";
                break;
            case "San Jose":
                info =   "San José"+"\n"+"Habitantes: 339 581 \n" +
                        "Lugares de Interés: Plaza de la Cultura, Museo de Jade, Museo Nacional de Costa Rica\n" +
                        "Restaurantes: Tenedor Argentino, La esquina de Buenos Aires, Restaurante Grano de Oro\n" +
                        "Gasolineras:  Delta Avenida 10, Servicentro las Avenidas \n";
                break;
            case "Santa Ana":
                info =   "Santa Ana"+"\n"+"Habitantes: 60 453\n" +
                        "Lugares de Interés: Centro Turistico Ojo de Agua, Cerro Cedral, Centro de Conservación Santa Ana\n" +
                        "Restaurantes: Restaurante el Jardín, Doris Metroplitan, Bacchus Restaurante \n" +
                        "Gasolineras: Servicentro JSM Santa Ana\n";
                break;
            case "Ciudad Colon":
                info =   "Ciudad Colón"+"\n"+"Habitantes: 16 088\n" +
                        "Lugares de Interés: Waterfall Ciudad Colón, Anfiteatro de Villa, Parque Ciudad Colón, Senderos Colón. \n" +
                        "Restaurantes: Restaurante Casa76, Chirote, Conservatorium\n" +
                        "Gasolineras: Gasolinera Río Grande, Delta Mora\n";
                break;
            case "Alajuela":
                info =   place+"\n"+"Habitantes: 885 571 \n" +
                        "Lugares de Interés: Hacienda Alsacia, Parque Laguna de Fraijanes, Parque Nacional Volcán Poás, City Mall\n" +
                        "Restaurantes: El Break, Chino Alegre, Comida Caribeña con CoCo, Pesquería Da Limonata   \n" +
                        "Gasolineras: Bomba La Tropicana, Estación de Servicio La Ceiba, Cootaxa\n";
                break;
            case "Heredia":
                info =   place+"\n"+"Habitantes: 433 677\n" +
                        "Lugares de Interés:  Hospital San Vicente de Paul, Centro Comercial Oxígeno, Museo de Cultura Popular \n" +
                        "Restaurantes: Restaurante Alok Fusion Costarricense, Ekeko Perú & Grill, Caprichos\n" +
                        "Gasolineras: Servicentro San Pablo y Gas LP, Estación de Servicio Santa Lucía, Delta Los Ángeles. \n";
                break;
            case "":
                info = "Favor entrar un lugar";
                break;
            default:
                info = "Lugar no encontrado";

        }
        JOptionPane.showMessageDialog(null, info);
    }
}
