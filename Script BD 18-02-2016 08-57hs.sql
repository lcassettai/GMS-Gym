USE [master]
GO
/****** Object:  Database [trabajoFinal]    Script Date: 18/02/2016 8:57:20 ******/
CREATE DATABASE [trabajoFinal]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'trabajoFinal', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.LUCHOSQL2012\MSSQL\DATA\trabajoFinal.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'trabajoFinal_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.LUCHOSQL2012\MSSQL\DATA\trabajoFinal_log.ldf' , SIZE = 1088KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [trabajoFinal] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [trabajoFinal].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [trabajoFinal] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [trabajoFinal] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [trabajoFinal] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [trabajoFinal] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [trabajoFinal] SET ARITHABORT OFF 
GO
ALTER DATABASE [trabajoFinal] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [trabajoFinal] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [trabajoFinal] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [trabajoFinal] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [trabajoFinal] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [trabajoFinal] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [trabajoFinal] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [trabajoFinal] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [trabajoFinal] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [trabajoFinal] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [trabajoFinal] SET  ENABLE_BROKER 
GO
ALTER DATABASE [trabajoFinal] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [trabajoFinal] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [trabajoFinal] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [trabajoFinal] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [trabajoFinal] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [trabajoFinal] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [trabajoFinal] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [trabajoFinal] SET RECOVERY FULL 
GO
ALTER DATABASE [trabajoFinal] SET  MULTI_USER 
GO
ALTER DATABASE [trabajoFinal] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [trabajoFinal] SET DB_CHAINING OFF 
GO
ALTER DATABASE [trabajoFinal] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [trabajoFinal] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'trabajoFinal', N'ON'
GO
USE [trabajoFinal]
GO
/****** Object:  StoredProcedure [dbo].[buscarAlumno]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[buscarAlumno]
@dato varchar(40) = ''
as
SELECT codAlumno,nombre,apellido,fecNac,sexo,direccion,telefono,telefonoAyuda,dni,activo,comentario 
FROM alumnos 
WHERE (nombre like @dato OR apellido like @dato OR dni like @dato) AND activo = 1








GO
/****** Object:  StoredProcedure [dbo].[buscarClases]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[buscarClases]
@idTipoActividad int,
@idDia int
AS
IF(@idDia < 7)
	SELECT  codClase,tipoActividad,d.idDia,dia,apellido,horaInicio + ' - ' + horaFin,cupo
	FROM clases c INNER JOIN tipoActividades ta ON ta.idTipoActividad = c.idTipoActividad
			INNER JOIN Empleados e ON e.codEmpleado = c.codEmpleado
			INNER JOIN DiasSemana d ON d.idDia = c.idDia
	WHERE habilitada = 'true' AND c.idTipoActividad = @idTipoActividad AND c.idDia = @idDia
	order by 3
ELSE
	SELECT  codClase,tipoActividad,d.idDia,dia,apellido,horaInicio + ' - ' + horaFin,cupo
	FROM clases c INNER JOIN tipoActividades ta ON ta.idTipoActividad = c.idTipoActividad
			INNER JOIN Empleados e ON e.codEmpleado = c.codEmpleado
			INNER JOIN DiasSemana d ON d.idDia = c.idDia
	WHERE habilitada = 'true' AND c.idTipoActividad = @idTipoActividad
	order by 3









GO
/****** Object:  StoredProcedure [dbo].[buscarReservasActivarParaCancelar]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[buscarReservasActivarParaCancelar]

@dato varchar(40) = '',
@idTipoActividad int,
@dia int = 0
AS
if(@dia < 7)
select idReserva,apellido + ', ' + nombre AS Alumno,tipoActividad AS Actividad,dia,horaInicio + ' - ' + c.horaFin AS Horario,habilitado
from  reservas r INNER JOIN clases c ON r.codClase = c.codClase
	  INNER JOIN tipoActividades ta ON c.idTipoActividad = ta.idTipoActividad
	  INNER JOIN Alumnos a ON a.codAlumno = r.codAlumno
	  INNER JOIN DiasSemana ds ON ds.idDia = c.idDia
where (nombre like @dato OR apellido like @dato OR dni like @dato) AND habilitado = 'true' AND c.idTipoActividad = @idTipoActividad  AND c.idDia = @dia
ELSE
select idReserva,apellido + ', ' + nombre AS Alumno,tipoActividad AS Actividad,dia,horaInicio + ' - ' + c.horaFin AS Horario,habilitado
from  reservas r INNER JOIN clases c ON r.codClase = c.codClase
	  INNER JOIN tipoActividades ta ON c.idTipoActividad = ta.idTipoActividad
	  INNER JOIN Alumnos a ON a.codAlumno = r.codAlumno
	  INNER JOIN DiasSemana ds ON ds.idDia = c.idDia
where (nombre like @dato OR apellido like @dato OR dni like @dato) AND habilitado = 'true' AND c.idTipoActividad = @idTipoActividad 









GO
/****** Object:  StoredProcedure [dbo].[buscarReservasActivas]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[buscarReservasActivas]
AS
select idReserva,apellido + ', ' + nombre AS Alumno,tipoActividad AS Actividad,dia,horaInicio + ' - ' + c.horaFin AS Horario,habilitado
from  reservas r INNER JOIN clases c ON r.codClase = c.codClase
	  INNER JOIN tipoActividades ta ON c.idTipoActividad = ta.idTipoActividad
	  INNER JOIN Alumnos a ON a.codAlumno = r.codAlumno
	  INNER JOIN DiasSemana ds ON ds.idDia = c.idDia
where habilitado = 'true'


GO
/****** Object:  StoredProcedure [dbo].[editarClase]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[editarClase]
@cupo int,
@actividad int,
@empleado int,
@hIni varchar(40),
@hfin varchar(40),
@codClase int,
@dia int
AS
UPDATE Clases
SET cupo = @cupo, 
	idTipoActividad = @actividad, 
	codEmpleado = @empleado, 
	horaInicio = @hIni,
    horaFin = @hfin,
	idDia = @dia
WHERE codClase = @codClase






GO
/****** Object:  StoredProcedure [dbo].[eliminarClase]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[eliminarClase]
@codigo int
AS
UPDATE clases
SET habilitada = 'False'
WHERE codClase =  @codigo






GO
/****** Object:  StoredProcedure [dbo].[nuevaClase]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[nuevaClase]
@cupo int,
@actividad int,
@empleado int,
@hIni varchar(40),
@hFin varchar(40),
@dia int
AS
INSERT INTO clases(cupo,idTipoActividad,codEmpleado,horaInicio,horaFin,habilitada,idDia)
VALUES (@cupo,@actividad,@empleado,@hIni,@hFin,'True',@dia)






GO
/****** Object:  StoredProcedure [dbo].[nuevaReserva]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[nuevaReserva]
@idInscripcion int,
@codClase int,
@codAlumno int
AS
insert into reservas(idInscripcion,codClase,codAlumno,habilitado)
values (@idInscripcion,@codClase,@codAlumno,'true')



GO
/****** Object:  StoredProcedure [dbo].[obtenerActividadInscripto]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[obtenerActividadInscripto]
@alumno int
AS
SELECT tipoActividad,ta.idTipoActividad
FROM inscripciones i INNER JOIN Actividades a ON i.idActividad = a.idActividad
					 INNER JOIN tipoActividades ta ON ta.idTipoActividad = a.idTipoActividad
WHERE codAlumno = @alumno AND i.habilitado = 'true'





GO
/****** Object:  StoredProcedure [dbo].[obtenerAlumnosHabilitados]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[obtenerAlumnosHabilitados]
AS
SELECT codAlumno,nombre,apellido,fecNac,sexo,direccion,telefono,telefonoAyuda,dni,activo,comentario 
FROM alumnos
WHERE activo = 'true'











GO
/****** Object:  StoredProcedure [dbo].[obtenerClases]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[obtenerClases]
AS
SELECT apellido + ' ' + nombre As 'Profesor',tipoActividad,cupo,horaInicio,horaFin,ta.idTipoActividad,e.codEmpleado,codClase,idDia,habilitada
FROM clases c INNER JOIN Empleados e ON c.codEmpleado = e.codEmpleado
			  INNER JOIN tipoActividades ta ON c.idTipoActividad = ta.idTipoActividad
WHERE habilitada = 'true'
ORDER BY 2







GO
/****** Object:  StoredProcedure [dbo].[obtenerClaseSeleccionada]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[obtenerClaseSeleccionada]
@idTipoAct int,
@codEmpleado int,
@idDia int,
@horario varchar(50)
AS
select *
from clases
where idTipoActividad = @idTipoAct and codEmpleado = @codEmpleado and habilitada = 'true' and idDia = @idDia and CONCAT(horaInicio,' - ',horaFin) = @horario





GO
/****** Object:  StoredProcedure [dbo].[obtenerDeudoresDelAño]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[obtenerDeudoresDelAño]
AS
SELECT month(fecha),sum(monto) 
FROM deudores d INNER JOIN pagoCuota pc ON pc.idPagoCuota = d.idPagoCuota  
WHERE pagado = 'false' AND year(fecha) = year(GETDATE())
GROUP BY month(fecha)

GO
/****** Object:  StoredProcedure [dbo].[obtenerDiasActividadDisponible]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[obtenerDiasActividadDisponible]
@codEmpleado int,
@codActividad int
AS
select distinct ds.idDia,dia
from DiasSemana ds inner join clases c ON c.idDia = ds.idDia
where c.codEmpleado = @codEmpleado and c.idTipoActividad = @codActividad AND c.habilitada = 'true'






GO
/****** Object:  StoredProcedure [dbo].[obtenerHorarioDisponible]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[obtenerHorarioDisponible] 
@codEmpleado int,
@codActividad int,
@idDia int
AS 
select codClase,horaInicio,horaFin 
from Clases
where codEmpleado = @codEmpleado and idTipoActividad = @codActividad and idDia = @idDia AND habilitada = 'true'





GO
/****** Object:  StoredProcedure [dbo].[obtenerProfesorDeActividad]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[obtenerProfesorDeActividad]
@idActividad int
AS
select distinct c.codEmpleado,apellido 
from empleados e INNER JOIN Clases c ON e.codEmpleado = c.codEmpleado
where c.idTipoActividad = @idActividad  AND c.habilitada = 'true' AND e.activo = 'true'





GO
/****** Object:  StoredProcedure [dbo].[obtenerProfesores]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[obtenerProfesores]
AS
SELECT codEmpleado,apellido,nombre
FROM empleados 
WHERE idTipoEmpleado = 2 AND  activo = 'true'







GO
/****** Object:  StoredProcedure [dbo].[obtenerTotalPagosAño]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[obtenerTotalPagosAño]
AS
SELECT month(fecha),sum(monto-montoDescuento)'Monto total' 
FROM detallePago dp INNER JOIN pagoCuota pc ON dp.idpagoCuota =  pc.idPagoCuota
WHERE year(fecha) = year(GETDATE())
GROUP BY month(fecha)

GO
/****** Object:  StoredProcedure [dbo].[SP_actualizarPromocion]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[SP_actualizarPromocion]
@id integer,
@promocion varchar(40) ,
@descrip varchar(300) = '' ,
@monto money = 0
AS
UPDATE promociones
SET promocion = @promocion, descripcion = @descrip,
	montoDescuento = @monto
WHERE idPromocion = @id











GO
/****** Object:  StoredProcedure [dbo].[sp_buscarAlumnoDni]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_buscarAlumnoDni]
@dni varchar(30)
AS
select codAlumno,nombre,apellido,dni,activo
from alumnos
where dni = @dni and activo = 'true'











GO
/****** Object:  StoredProcedure [dbo].[SP_BuscarDetallePago]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[SP_BuscarDetallePago]
@id int = 0
AS
select promocion,p.montoDescuento,actividad,precio
from   detallePago dp inner join actividades a on dp.idActividad = a.idActividad
          inner join promociones p ON p.idPromocion = dp.idPromocion
where idpagoCuota = @id











GO
/****** Object:  StoredProcedure [dbo].[SP_BuscarDeudores]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[SP_BuscarDeudores]
@apellido varchar(30) = '%%',
@dni varchar(30) = '%%',
@fechaIn datetime = '01/11/1990',
@fechaFin datetime = '05/11/2015'
AS
IF @fechaFin = '05/11/2015'
  BEGIN
  select @fechaFin = getdate()
  END

select idDeudor,a.Apellido +' '+ a.nombre As alumno,a.dni,monto, CONVERT(VARCHAR(10),fecha,103),pagado
from Alumnos a INNER JOIN deudores d ON a.codAlumno = d.codAlumno 
     INNER JOIN pagoCuota pc ON d.idPagoCuota = pc.idPagoCuota
	 where pagado = 'false' AND apellido LIKE @apellido AND dni LIKE @dni  AND CONVERT(VARCHAR(11),fecha,103) between @fechaIn and @fechaFin











GO
/****** Object:  StoredProcedure [dbo].[SP_buscarEmpleado]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_buscarEmpleado]
@dni varchar(30)
AS
select codEmpleado,nombre,apellido,dni,activo
from empleados
where dni = @dni and activo = 'true'











GO
/****** Object:  StoredProcedure [dbo].[SP_buscarInscripcion]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[SP_buscarInscripcion]
@idAlumno int  = 0
AS
select a.codAlumno,actividad,fechaInicio,fechaFin,i.diasVencimiento,i.habilitado,idInscripcion,tipoActividad
from inscripciones i inner join Alumnos a on i.codAlumno = a.codAlumno 
	inner join Actividades ac on i.idActividad  = ac.idActividad
	inner join tipoActividades ta ON ta.idTipoActividad = ac.idTipoActividad
	where fechaFin >= GETDATE() and i.codAlumno = @idAlumno and i.habilitado = 'true'



	










GO
/****** Object:  StoredProcedure [dbo].[SP_BUSCARPAGOS]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[SP_BUSCARPAGOS]
@aluApellido varchar(40) = '%%',
@empApellido varchar(40) = '%%',
@dni varchar(39) = '%%',
@fechaIn datetime = '01/11/1990',
@fechaFin datetime = '05/11/2015'
AS
IF @fechaFin = '05/11/2015'
  BEGIN
  select @fechaFin = getdate()
  END
select p.idPagoCuota,a.Apellido, a.nombre, a.dni,fecha,e.apellido, sum(monto-montoDescuento),montoEntregado
FROM  alumnos a inner join pagoCuota p on a.codAlumno = p.codAlumno 
          inner join empleados e on e.codEmpleado = p.codEmpleado 
          inner join detallePago dp ON p.idPagoCuota = dp.idpagoCuota
group by  p.idPagoCuota,a.Apellido, a.nombre, a.dni,fecha,e.apellido,montoEntregado
having  a.apellido LIKE @aluApellido AND e.apellido LIKE @empApellido AND a.dni LIKE @dni AND CONVERT(VARCHAR(11),fecha,103) between @fechaIn and @fechaFin 
order by fecha desc

select * from pagoCuota









GO
/****** Object:  StoredProcedure [dbo].[SP_cargarPromocion]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[SP_cargarPromocion]
@promocion varchar(40) = '',
@descrip varchar(300) = '',
@monto money = 0
As
if(@promocion != '')
	insert into promociones(promocion,descripcion,montoDescuento,habilitado)
	values(@promocion,@descrip,@monto,'true')
else
	print 'no se pudo cargar,ingrese el nombre de la promocion'











GO
/****** Object:  StoredProcedure [dbo].[SP_eliminarPromocion]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[SP_eliminarPromocion]
@id integer
AS
UPDATE promociones
SET habilitado = 'false'
WHERE idPromocion = @id











GO
/****** Object:  StoredProcedure [dbo].[SP_obtenerAsistenciaAlumnos]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_obtenerAsistenciaAlumnos]
@apellido varchar(30) = '%%',
@nombre varchar(30) = '%%',
@dni varchar(30) = '%%',
@fechaIn datetime = '01/11/1990',
@fechaFin datetime = '05/11/2015'
AS
IF @fechaFin = '05/11/2015'
  BEGIN
  select @fechaFin = getdate()
  END
select a.codAlumno,nombre,apellido,dni, CONVERT(VARCHAR(10),fecha,103) AS Fecha, CONVERT(VARCHAR(5),fecha,108) as Hora
from Alumnos a INNER JOIN asistenciaAlumnos asist ON a.codAlumno = asist.codAlumno
WHERE apellido like @apellido AND nombre like @nombre AND dni like @dni  AND CONVERT(VARCHAR(11),fecha,103) between @fechaIn and @fechaFin
ORDER BY fecha desc,Hora desc











GO
/****** Object:  StoredProcedure [dbo].[SP_obtenerAsistenciaEmpleados]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[SP_obtenerAsistenciaEmpleados]
@apellido varchar(30) = '%%',
@nombre varchar(30) = '%%',
@dni varchar(30) = '%%',
@fechaIn datetime = '01/11/1990',
@fechaFin datetime = '05/11/2015'
AS
IF @fechaFin = '05/11/2015'
  BEGIN
  select @fechaFin = getdate()
  END
select e.codEmpleado,nombre,apellido,dni, CONVERT(VARCHAR(10),fecha,103) AS Fecha, CONVERT(VARCHAR(5),fecha,108) as Hora
from empleados e INNER JOIN AsistenciaEmpleados ae ON ae.codEmpleado = e.codEmpleado
WHERE apellido like @apellido AND nombre like @nombre AND dni like @dni  AND CONVERT(VARCHAR(11),fecha,103) between @fechaIn and @fechaFin
ORDER BY fecha desc,Hora desc











GO
/****** Object:  StoredProcedure [dbo].[SP_presenteAlumno]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_presenteAlumno]
@id int
AS
declare @fecha datetime = getdate()

insert into asistenciaAlumnos(codAlumno,fecha)
values(@id,@fecha)











GO
/****** Object:  StoredProcedure [dbo].[SP_presenteEmpleado]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[SP_presenteEmpleado]
@id int
AS
declare @fecha datetime = getdate()

insert into asistenciaEmpleados(codEmpleado,fecha)
values(@id,@fecha)











GO
/****** Object:  StoredProcedure [dbo].[SP_registrarDetalle]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[SP_registrarDetalle]
@monto money = 0,
@idPromocion int = 0,
@idActividad int = 0,
@descuento money = 0
AS
declare @idPagoCuota int = 0
SELECT @idPagoCuota = MAX(idPagoCuota) FROM pagoCuota
INSERT INTO detallePago(monto,idPromocion,idActividad,idpagoCuota,montoDescuento)
VALUES (@monto,@idPromocion,@idActividad,@idPagoCuota,@descuento)











GO
/****** Object:  StoredProcedure [dbo].[SP_registrarDeudor]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[SP_registrarDeudor]
@monto money = 0,
@pagado  bit = 'false',
@codAlumno int = 0
AS
declare @idPagoCuota int = 0
select @idPagoCuota = max(idPagoCuota) from pagoCuota
insert into deudores(monto,pagado,codAlumno,idPagoCuota)
VALUES (@monto,@pagado,@codAlumno,@idPagoCuota)












GO
/****** Object:  StoredProcedure [dbo].[SP_registrarInscripciones]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[SP_registrarInscripciones]
@fechaInicio datetime,
@fechaFIN datetime,
@diasVencimiento int = 0,
@idActividad int = 0,
@codAlumno int = 0
AS
INSERT INTO inscripciones(fechaInicio,fechaFin,diasVencimiento,idActividad,codAlumno,habilitado)
VALUES (@fechaInicio,@fechaFIN,@diasVencimiento,@idActividad,@codAlumno,'true')











GO
/****** Object:  StoredProcedure [dbo].[SP_registrarPagoCuota]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[SP_registrarPagoCuota]
@fecha datetime,
@montoEntregado money = 0,
@alumno int = 0,
@codEmpleado int = 0
AS
SELECT @fecha = GETDATE()
INSERT INTO pagoCuota (fecha,montoEntregado,codAlumno,codEmpleado)
VALUES (@fecha,@montoEntregado,@alumno,@codEmpleado)











GO
/****** Object:  StoredProcedure [dbo].[SP_reportesDetalladoTotalPagos]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_reportesDetalladoTotalPagos]
@fechaIn datetime ,
@fechaFin datetime 
AS
select pc.idPagoCuota,'Pago cuota' As 'Tipo de Pago',alu.apellido + ' ' + alu.nombre As alumno, sum(monto),sum(dp.montoDescuento),montoEntregado,e.apellido As 'Empleado',CONVERT(VARCHAR(10),fecha,103) AS Fecha ,CONVERT(VARCHAR(5),fecha,108) as Hora
from detallePago dp 
inner join pagoCuota pc ON dp.idpagoCuota = pc.idPagoCuota 
INNER JOIN promociones p ON dp.idPromocion = p.idPromocion
INNER JOIN Actividades a ON dp.idActividad = a.idActividad
INNER JOIN Empleados e ON e.codEmpleado = pc.codEmpleado
INNER JOIN Alumnos alu ON alu.codAlumno = pc.codAlumno
WHERE CONVERT(VARCHAR(11),fecha,103) between @fechaIn and @fechaFin
group by pc.idPagoCuota,alu.apellido,alu.nombre,e.apellido,CONVERT(VARCHAR(10),fecha,103) ,CONVERT(VARCHAR(5),fecha,108),montoEntregado
Union
select pd.idPagoDeuda,'Cancelacion Deuda', a.apellido + ' ' + a.nombre As alumno,montoEntregado, 0, montoEntregado,
	   e.apellido As 'Empleado', CONVERT(VARCHAR(10),fecha,103) AS Fecha ,CONVERT(VARCHAR(5),fecha,108) as Hora
from pagoDeuda pd INNER JOIN deudores d ON pd.idDeudor = d.idDeudor
	 INNER JOIN Alumnos a ON a.codAlumno = d.codAlumno
	 INNER JOIN Empleados e ON e.codEmpleado = pd.codEmpleado
WHERE CONVERT(VARCHAR(11),fecha,103) between @fechaIn and @fechaFin
Order by fecha desc, hora desc












GO
/****** Object:  StoredProcedure [dbo].[SP_SaldarDeuda]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[SP_SaldarDeuda]
@fecha datetime,
@montoEntregado money,
@idDeudor int,
@codEmpleado int,
@detalle varchar(300) = ''
AS
select @fecha = GETDATE()
insert into pagoDeuda(fecha,montoEntregado,idDeudor,codEmpleado,detalle)
Values (@fecha,@montoEntregado,@idDeudor,@codEmpleado,@detalle)











GO
/****** Object:  StoredProcedure [dbo].[SP_totalPagos]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[SP_totalPagos]
@fechaIn datetime ,
@fechaFin datetime 
AS
select sum(monto-montoDescuento)
from detallePago dp 
inner join pagoCuota pc ON dp.idpagoCuota = pc.idPagoCuota 
WHERE CONVERT(VARCHAR(11),fecha,103) between @fechaIn and @fechaFin











GO
/****** Object:  StoredProcedure [dbo].[SP_traerPromociones]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROC [dbo].[SP_traerPromociones]
AS
SELECT idPromocion,promocion,descripcion,montoDescuento
FROM promociones
WHERE habilitado = 1











GO
/****** Object:  StoredProcedure [dbo].[verificarCupoClases]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[verificarCupoClases]
@codClase int
AS

select cupo - count(r.codClase) 
from reservas r INNER JOIN clases c on r.codClase = c.codClase
where r.codClase = @codClase AND habilitado = 'true'
group by cupo




GO
/****** Object:  StoredProcedure [dbo].[verificarDeuda]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[verificarDeuda]
@id int = 0
AS
SELECT a.codAlumno,sum(monto)
from alumnos a inner join deudores d on a.codAlumno = d.codAlumno
where d.pagado = 'false'
group by a.codAlumno
having  a.codAlumno = @id











GO
/****** Object:  StoredProcedure [dbo].[verificarReservaAlumno]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[verificarReservaAlumno]
@idInscripcion int,
@codClase int,
@codAlumno int
AS
select *
from reservas
where idInscripcion = @idInscripcion AND codClase = @codClase AND codAlumno = @codAlumno and habilitado  = 'true'



GO
/****** Object:  Table [dbo].[Actividades]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Actividades](
	[idActividad] [int] IDENTITY(1,1) NOT NULL,
	[actividad] [varchar](30) NULL,
	[precio] [money] NULL,
	[cantDias] [int] NULL,
	[idTipoActividad] [int] NULL,
	[habilitado] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idActividad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Alumnos]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Alumnos](
	[codAlumno] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](30) NOT NULL,
	[apellido] [varchar](40) NOT NULL,
	[fecNac] [datetime] NULL,
	[sexo] [bit] NOT NULL,
	[direccion] [varchar](50) NULL,
	[telefono] [varchar](15) NULL,
	[telefonoAyuda] [varchar](15) NULL,
	[dni] [varchar](10) NULL,
	[activo] [bit] NULL,
	[comentario] [varchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[codAlumno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AsistenciaAlumnos]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AsistenciaAlumnos](
	[idAsistenciaAlu] [int] IDENTITY(1,1) NOT NULL,
	[codAlumno] [int] NULL,
	[fecha] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idAsistenciaAlu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[AsistenciaEmpleados]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AsistenciaEmpleados](
	[idAsistenciaEmpleado] [int] IDENTITY(1,1) NOT NULL,
	[codEmpleado] [int] NULL,
	[fecha] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[idAsistenciaEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Clases]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[Clases](
	[codClase] [int] IDENTITY(1,1) NOT NULL,
	[cupo] [int] NULL,
	[idTipoActividad] [int] NULL,
	[codEmpleado] [int] NULL,
	[horaInicio] [varchar](40) NULL,
	[horaFin] [varchar](40) NULL,
	[habilitada] [bit] NULL,
	[idDia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[codClase] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[detallePago]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detallePago](
	[idDetalle] [int] IDENTITY(1,1) NOT NULL,
	[monto] [money] NULL,
	[montoDescuento] [money] NULL,
	[idPromocion] [int] NULL,
	[idActividad] [int] NULL,
	[idpagoCuota] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idDetalle] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[deudores]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[deudores](
	[idDeudor] [int] IDENTITY(1,1) NOT NULL,
	[monto] [money] NULL,
	[detalle] [varchar](300) NULL,
	[pagado] [bit] NULL,
	[codAlumno] [int] NULL,
	[idPagoCuota] [int] NULL,
 CONSTRAINT [PK_deudores] PRIMARY KEY CLUSTERED 
(
	[idDeudor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DiasSemana]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DiasSemana](
	[idDia] [int] IDENTITY(1,1) NOT NULL,
	[Dia] [varchar](20) NULL,
 CONSTRAINT [PK_DiasSemana] PRIMARY KEY CLUSTERED 
(
	[idDia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Empleados]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Empleados](
	[codEmpleado] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](30) NOT NULL,
	[apellido] [varchar](40) NOT NULL,
	[fecNac] [datetime] NULL,
	[sexo] [bit] NOT NULL,
	[direccion] [varchar](50) NULL,
	[telefono] [varchar](15) NULL,
	[telefonoAyuda] [varchar](15) NULL,
	[dni] [varchar](12) NULL,
	[activo] [bit] NULL,
	[suplencias] [bit] NULL,
	[comentario] [varchar](300) NULL,
	[usuario] [varchar](30) NULL,
	[contraseña] [varchar](50) NULL,
	[idTipoEmpleado] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[codEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[inscripciones]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[inscripciones](
	[idInscripcion] [int] IDENTITY(1,1) NOT NULL,
	[fechaInicio] [datetime] NULL,
	[fechaFin] [datetime] NULL,
	[diasVencimiento] [int] NULL,
	[habilitado] [bit] NULL,
	[idActividad] [int] NULL,
	[codAlumno] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idInscripcion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[pagoCuota]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pagoCuota](
	[idPagoCuota] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [datetime] NULL,
	[montoEntregado] [money] NULL,
	[codAlumno] [int] NULL,
	[codEmpleado] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idPagoCuota] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[pagoDeuda]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pagoDeuda](
	[idPagoDeuda] [int] IDENTITY(1,1) NOT NULL,
	[montoEntregado] [float] NULL,
	[fecha] [datetime] NULL,
	[idDeudor] [int] NULL,
	[detalle] [varchar](300) NULL,
	[codEmpleado] [int] NULL,
 CONSTRAINT [PK_pagoDeuda] PRIMARY KEY CLUSTERED 
(
	[idPagoDeuda] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[promociones]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[promociones](
	[idPromocion] [int] IDENTITY(1,1) NOT NULL,
	[promocion] [varchar](40) NULL,
	[descripcion] [varchar](300) NULL,
	[montoDescuento] [money] NULL,
	[habilitado] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idPromocion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[reservas]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reservas](
	[idReserva] [int] IDENTITY(1,1) NOT NULL,
	[idInscripcion] [int] NULL,
	[codClase] [int] NULL,
	[codAlumno] [int] NULL,
	[habilitado] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[idReserva] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tipoActividades]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tipoActividades](
	[idTipoActividad] [int] IDENTITY(1,1) NOT NULL,
	[tipoActividad] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTipoActividad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tipoEmpleados]    Script Date: 18/02/2016 8:57:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tipoEmpleados](
	[idTipoEmpleado] [int] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[idTipoEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Actividades]  WITH CHECK ADD  CONSTRAINT [fk_TipoActividad_Actividad] FOREIGN KEY([idTipoActividad])
REFERENCES [dbo].[tipoActividades] ([idTipoActividad])
GO
ALTER TABLE [dbo].[Actividades] CHECK CONSTRAINT [fk_TipoActividad_Actividad]
GO
ALTER TABLE [dbo].[AsistenciaAlumnos]  WITH CHECK ADD  CONSTRAINT [fk_asistencia_alumno] FOREIGN KEY([codAlumno])
REFERENCES [dbo].[Alumnos] ([codAlumno])
GO
ALTER TABLE [dbo].[AsistenciaAlumnos] CHECK CONSTRAINT [fk_asistencia_alumno]
GO
ALTER TABLE [dbo].[AsistenciaEmpleados]  WITH CHECK ADD  CONSTRAINT [fk_asistencia_empleado] FOREIGN KEY([codEmpleado])
REFERENCES [dbo].[Empleados] ([codEmpleado])
GO
ALTER TABLE [dbo].[AsistenciaEmpleados] CHECK CONSTRAINT [fk_asistencia_empleado]
GO
ALTER TABLE [dbo].[Clases]  WITH CHECK ADD  CONSTRAINT [FK_Clases_DiasSemana] FOREIGN KEY([idDia])
REFERENCES [dbo].[DiasSemana] ([idDia])
GO
ALTER TABLE [dbo].[Clases] CHECK CONSTRAINT [FK_Clases_DiasSemana]
GO
ALTER TABLE [dbo].[Clases]  WITH CHECK ADD  CONSTRAINT [fk_empleado_clase] FOREIGN KEY([codEmpleado])
REFERENCES [dbo].[Empleados] ([codEmpleado])
GO
ALTER TABLE [dbo].[Clases] CHECK CONSTRAINT [fk_empleado_clase]
GO
ALTER TABLE [dbo].[Clases]  WITH CHECK ADD  CONSTRAINT [fk_tipoAct_clase] FOREIGN KEY([idTipoActividad])
REFERENCES [dbo].[tipoActividades] ([idTipoActividad])
GO
ALTER TABLE [dbo].[Clases] CHECK CONSTRAINT [fk_tipoAct_clase]
GO
ALTER TABLE [dbo].[detallePago]  WITH CHECK ADD  CONSTRAINT [fk_actividad_detalle] FOREIGN KEY([idActividad])
REFERENCES [dbo].[Actividades] ([idActividad])
GO
ALTER TABLE [dbo].[detallePago] CHECK CONSTRAINT [fk_actividad_detalle]
GO
ALTER TABLE [dbo].[detallePago]  WITH CHECK ADD  CONSTRAINT [fk_pago_detalle] FOREIGN KEY([idpagoCuota])
REFERENCES [dbo].[pagoCuota] ([idPagoCuota])
GO
ALTER TABLE [dbo].[detallePago] CHECK CONSTRAINT [fk_pago_detalle]
GO
ALTER TABLE [dbo].[detallePago]  WITH CHECK ADD  CONSTRAINT [fk_promocion_detalle] FOREIGN KEY([idPromocion])
REFERENCES [dbo].[promociones] ([idPromocion])
GO
ALTER TABLE [dbo].[detallePago] CHECK CONSTRAINT [fk_promocion_detalle]
GO
ALTER TABLE [dbo].[deudores]  WITH CHECK ADD  CONSTRAINT [FK_deudores_alumno] FOREIGN KEY([codAlumno])
REFERENCES [dbo].[Alumnos] ([codAlumno])
GO
ALTER TABLE [dbo].[deudores] CHECK CONSTRAINT [FK_deudores_alumno]
GO
ALTER TABLE [dbo].[deudores]  WITH CHECK ADD  CONSTRAINT [FK_deudores_PagoCuota] FOREIGN KEY([idPagoCuota])
REFERENCES [dbo].[pagoCuota] ([idPagoCuota])
GO
ALTER TABLE [dbo].[deudores] CHECK CONSTRAINT [FK_deudores_PagoCuota]
GO
ALTER TABLE [dbo].[Empleados]  WITH CHECK ADD  CONSTRAINT [fk_tipoEmpleado_Empleado] FOREIGN KEY([idTipoEmpleado])
REFERENCES [dbo].[tipoEmpleados] ([idTipoEmpleado])
GO
ALTER TABLE [dbo].[Empleados] CHECK CONSTRAINT [fk_tipoEmpleado_Empleado]
GO
ALTER TABLE [dbo].[inscripciones]  WITH CHECK ADD  CONSTRAINT [fk_actividad_inscripciones] FOREIGN KEY([idActividad])
REFERENCES [dbo].[Actividades] ([idActividad])
GO
ALTER TABLE [dbo].[inscripciones] CHECK CONSTRAINT [fk_actividad_inscripciones]
GO
ALTER TABLE [dbo].[inscripciones]  WITH CHECK ADD  CONSTRAINT [fk_alumnos_inscripcion] FOREIGN KEY([codAlumno])
REFERENCES [dbo].[Alumnos] ([codAlumno])
GO
ALTER TABLE [dbo].[inscripciones] CHECK CONSTRAINT [fk_alumnos_inscripcion]
GO
ALTER TABLE [dbo].[pagoCuota]  WITH CHECK ADD  CONSTRAINT [fk_codAlumno_cuota] FOREIGN KEY([codAlumno])
REFERENCES [dbo].[Alumnos] ([codAlumno])
GO
ALTER TABLE [dbo].[pagoCuota] CHECK CONSTRAINT [fk_codAlumno_cuota]
GO
ALTER TABLE [dbo].[pagoCuota]  WITH CHECK ADD  CONSTRAINT [fk_codEmpleado_cuota] FOREIGN KEY([codEmpleado])
REFERENCES [dbo].[Empleados] ([codEmpleado])
GO
ALTER TABLE [dbo].[pagoCuota] CHECK CONSTRAINT [fk_codEmpleado_cuota]
GO
ALTER TABLE [dbo].[pagoDeuda]  WITH CHECK ADD  CONSTRAINT [fk_pagoDeuda_Deudor] FOREIGN KEY([idDeudor])
REFERENCES [dbo].[deudores] ([idDeudor])
GO
ALTER TABLE [dbo].[pagoDeuda] CHECK CONSTRAINT [fk_pagoDeuda_Deudor]
GO
ALTER TABLE [dbo].[pagoDeuda]  WITH CHECK ADD  CONSTRAINT [fk_pagoDeudora_Empleado] FOREIGN KEY([codEmpleado])
REFERENCES [dbo].[Empleados] ([codEmpleado])
GO
ALTER TABLE [dbo].[pagoDeuda] CHECK CONSTRAINT [fk_pagoDeudora_Empleado]
GO
ALTER TABLE [dbo].[reservas]  WITH CHECK ADD  CONSTRAINT [fk_clase_reservas] FOREIGN KEY([codClase])
REFERENCES [dbo].[Clases] ([codClase])
GO
ALTER TABLE [dbo].[reservas] CHECK CONSTRAINT [fk_clase_reservas]
GO
ALTER TABLE [dbo].[reservas]  WITH CHECK ADD  CONSTRAINT [fk_inscripciones_reservas] FOREIGN KEY([idInscripcion])
REFERENCES [dbo].[inscripciones] ([idInscripcion])
GO
ALTER TABLE [dbo].[reservas] CHECK CONSTRAINT [fk_inscripciones_reservas]
GO
USE [master]
GO
ALTER DATABASE [trabajoFinal] SET  READ_WRITE 
GO


use trabajoFinal
go

CREATE TRIGGER TR_pagoDeuda 
ON pagoDeuda
FOR INSERT 
AS
declare @montoEntregado money,
 @montoAnterior money,
 @montoActual money, 
 @id int

SELECT @montoEntregado = montoEntregado,@id = idDeudor
FROM inserted

SELECT @montoAnterior = monto
FROM deudores
WHERE idDeudor = @id

select @montoActual = @montoAnterior - @montoEntregado

IF(@montoActual = 0)
update deudores 
set pagado = 'true', monto = @montoActual
WHERE idDeudor = @id
ELSE
update deudores 
set monto = @montoActual
WHERE idDeudor = @id
go


use trabajoFinal
go

--Tabla de tipo empleados----

insert into tipoEmpleados (tipo) values ('Atencion al cliente')
insert into tipoEmpleados (tipo) values ('Profesor')
insert into tipoEmpleados (tipo) values ('Administrador')

--Tabla Empleados---


insert into Empleados (nombre,apellido,fecNac,sexo,direccion,telefono,telefonoAyuda,dni,activo,suplencias,comentario,usuario,contraseña,idTipoEmpleado)
values ('Luciano','Cassettai','23/11/1991',1,'San lorenzo 213','3764902330',null,'35004172',1,0,null,'lcassettai','lucho123',3)


insert into Empleados (nombre,apellido,fecNac,sexo,direccion,telefono,telefonoAyuda,dni,activo,suplencias,comentario,usuario,contraseña,idTipoEmpleado)
values ('Rita','Perez','10/12/1980','false','San martin 24','3515151487',null,'32548741','true','false',null,'rita1980','rita123',1)


--Tabla Alumnos


insert into alumnos(nombre,apellido,fecNac,sexo,direccion,telefono,telefonoAyuda,dni,activo,comentario)
values('Veronico','Fernandez','10/12/1970','false',null,'351425784',null,'35410414','false',null)

insert into alumnos(nombre,apellido,fecNac,sexo,direccion,telefono,telefonoAyuda,dni,activo,comentario)
values('Juan','Perez','10/12/1985','true',null,'3510245784',null,'32548714','true',null)


--Tipos de actividades

insert into tipoActividades (tipoActividad)
values ('Musculacion')

insert into tipoActividades (tipoActividad)
values ('Crossfit')

insert into tipoActividades (tipoActividad)
values ('Spinning')

insert into tipoActividades (tipoActividad)
values ('Zumba')



--Actividades 

insert into Actividades(actividad,precio,cantDias,idTipoActividad,habilitado)
values('Musculacion pase libre',400,24,1,'true')

insert into Actividades(actividad,precio,cantDias,idTipoActividad,habilitado)
values('Musculacion 2 veces',200,8,1,'true')

insert into Actividades(actividad,precio,cantDias,idTipoActividad,habilitado)
values('Musculacion 3 veces',250,12,1,'true')

insert into Actividades(actividad,precio,cantDias,idTipoActividad,habilitado)
values('Cross fit pase libre',600,20,2,'true')

insert into Actividades(actividad,precio,cantDias,idTipoActividad,habilitado)
values('Cross fit 2 veces',450,8,2,'true')

insert into Actividades(actividad,precio,cantDias,idTipoActividad,habilitado)
values('Cross fit 3 veces',500,12,2,'true')


insert into promociones(montoDescuento,promocion,habilitado,descripcion)
values (0,'Ninguna','true','')


--Dias de la semana

insert into diasSemana(dia)
values('lunes')

insert into diasSemana(dia)
values('Martes')

insert into diasSemana(dia)
values('Miercoles')

insert into diasSemana(dia)
values('Jueves')

insert into diasSemana(dia)
values('Viernes')

insert into diasSemana(dia)
values('Sabado')
