DROP TABLE IF EXISTS producto;

CREATE TABLE producto (
  codigo varchar(4),
  nombre varchar(20),
  precio decimal(6,2),
  fecha varchar(10),
  pais_origen varchar(9),
  PRIMARY KEY (codigo) 
);


INSERT INTO producto (codigo, nombre, precio, fecha, pais_origen) VALUES
('AR01', 'Tubos', 140.35, '1997-04-03', 'China'),
('AR02', 'Plato Decorativo', 45.08, '1997-07-06', 'China'),
('AR03', 'Juego de te', 36.06, '1997-01-15', 'China'),
('AR04', 'Cenicero', 16.46, '1997-02-07', 'Japón'),
('AR05', 'Maceta', 24.20, '1997-02-23', 'España'),
('AR06', 'Jarra china', 106.48, '1997-09-02', 'China'),
('AR07', 'Tarje Caballero', 237.15, '1997-11-03', 'Italia'),
('AR08', 'Pantalón Señora', 145.19, '1997-01-05', 'Marruecos'),
('AR09', 'Camisa Caballero', 55.94, '1997-11-08', 'España'),
('AR10', 'Blusa Sra.', 84.21, '1997-03-18', 'China'),
('AR11', 'Cazadora piel', 435.58, '1997-10-07', 'Italia'),
('AR12', 'Abrigo Caballero', 203.27, '1997-05-07', 'Italia'),
('AR13', 'Abrigo Sra', 300.06, '1997-03-05', 'Marruecos'),
('AR14', 'Cinturón de piel', 3.61, '1997-12-05', 'España'),
('AR15', 'Raqueta Tenis', 77.89, '1997-03-20', 'Usa'),
('AR16', 'Chándal', 193.39, '1997-09-13', 'Usa'),
('AR17', 'Tren Eléctrico', 1254.48, '1997-03-07', 'Japón'),
('AR18', 'Pistola Olímpica', 38.95, '1997-05-23', 'Suecia'),
('AR19', 'Monopatín', 93.04, '1997-11-11', 'Marruecos'),
('AR20', 'Balón baloncesto', 62.73, '1997-06-25', 'Japón'),
('AR21', 'Balón Fútbol', 36.60, '1997-05-07', 'España'),
('AR22', 'Sudadera', 365.98, '1997-03-11', 'Usa'),
('AR23', 'Bicicleta de montaña', 470.42, '1997-03-14', 'Usa'),
('AR24', 'Destornillador', 5.52, '1997-10-22', 'España'),
('AR25', 'Serrucho', 25.17, '1997-03-23', 'Francia'),
('AR26', 'Llave Inglesa', 20.33, '1997-04-23', 'Usa'),
('AR27', 'Alicates', 5.61, '1997-04-17', 'Italia'),
('AR28', 'Martillo', 9.50, '1997-04-09', 'España'),
('AR29', 'Destornillador', 7.55, '1997-02-20', 'Francia'),
('AR30', 'Lima Grande', 18.39, '1997-10-08', 'España'),
('AR31', 'Juego de brocas', 12.58, '1997-04-07', 'Taiwán'),
('AR32', 'Coche Teledirigido', 132.87, '1997-05-26', 'Marruecos'),
('AR33', 'Correpasillos', 86.11, '1997-11-04', 'Japón'),
('AR34', 'Consola Video', 368.79, '1997-09-24', 'Usa'),
('AR35', 'Muñeca Andadora', 87.55, '1997-04-10', 'España'),
('AR36', 'Fuerte de soldados', 119.75, '1997-11-25', 'Japón'),
('AR37', 'Pistola con sonidos', 47.71, '1997-02-15', 'España'),
('AR38', 'Pie de lámpara', 33.13, '1997-05-27', 'Turquía');

