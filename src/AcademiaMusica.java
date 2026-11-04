// --- LLAMADO A FUNCIONES (ASIGNACION DE COSTOS Y CALCULOS) ---
                    cuotaBase = calcularCuotaBase(tipoTramite);
                    mensualidad = calcularMensualidad(tipoClase);
                    costoRenta = calcularCostoRenta(traeInstrumento);
                    
                    subtotal = cuotaBase + mensualidad + costoRenta;
                    montoDescuento = calcularMontoDescuento(cuotaBase, traeInstrumento, porcentajeDescuento);
                    totalPagar = subtotal - montoDescuento;
                    
                    // --- MODULO: COMPROBANTE DE PAGO ---
                    System.out.println();
                    System.out.println("===========================================");
                    System.out.println("                 COMPROBANTE               ");
                    System.out.println("             ESCUELA DE MUSICA             ");
                    System.out.println("===========================================");
                    System.out.println("Alumno: " + nomEstudiante);
                    System.out.println("Matricula: " + numEstudiante);
                    System.out.println("Tramite: " + tipoTramite + " ($" + cuotaBase + ")");
                    System.out.println("Curso: " + cursoSeleccionado);
                    System.out.println("Modalidad: " + tipoClase + " ($" + mensualidad + ")");
                    System.out.println("Costo Renta Material: $" + costoRenta);
                    System.out.println("-------------------------------------------");
                    System.out.println("Subtotal: $" + subtotal);
                    System.out.println("Descuento (" + porcentajeDescuento + "%): -$" + montoDescuento);
                    System.out.println("TOTAL A PAGAR: $" + totalPagar);
                    System.out.println("===========================================");
                    System.out.println("¡Gracias por inscribirse!");
                    System.out.println();
                    break;
