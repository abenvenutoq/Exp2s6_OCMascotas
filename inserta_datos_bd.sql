-- Inserción de 10 registros en la tabla orden_compra
INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('11111111-1', 'Juan Pérez', 501, 'Notebook Asus 15"', 1);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('22222222-2', 'María Gómez', 502, 'Mouse Inalámbrico Logitech', 2);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('33333333-3', 'Carlos Silva', 503, 'Teclado Mecánico', 1);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('44444444-4', 'Ana Soto', 504, 'Monitor Samsung 24"', 2);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('55555555-5', 'Pedro Rojas', 505, 'Silla Ergonomica', 1);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('66666666-6', 'Laura Torres', 501, 'Notebook Asus 15"', 1);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('77777777-7', 'Jorge Riquelme', 506, 'Auriculares Sony', 3);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('88888888-8', 'Camila Vega', 507, 'Disco Duro Externo 1TB', 2);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('99999999-9', 'Luis Tapia', 502, 'Mouse Inalámbrico Logitech', 5);

INSERT INTO orden_compra (rut_cliente, nombre_cliente, id_producto, nombre_producto, cantidad) 
VALUES ('10101010-0', 'Sofía Castro', 508, 'Impresora Multifuncional', 1);

-- Guardar los cambios permanentemente en la base de datos
COMMIT;