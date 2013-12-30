package fr.theflogat.technicalWizardry.vec;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public class Vector {
    
    public double x;
    public double y;
    public double z;

    public Vector()
    {
    }
    

    public Vector(double dx, double dy, double dz)
    {
        x = dx;
        y = dy;
        z = dz;
    }

    public Vector(Vector vec)
    {
        x = vec.x;
        y = vec.y;
        z = vec.z;
    }

    public Vector copy()
    {
        return new Vector(this);
    }
    
    public static Vector fromEntity(Entity e)
    {
        return new Vector(e.posX, e.posY, e.posZ);
    }
    
    public static Vector fromEntityCenter(Entity e)
    {
        return new Vector(e.posX, e.posY - e.yOffset + e.height/2, e.posZ);
    }

    public static Vector fromTileEntity(TileEntity e)
    {
        return new Vector(e.xCoord, e.yCoord, e.zCoord);
    }
    
    public static Vector fromTileEntityCenter(TileEntity e)
    {
        return new Vector(e.xCoord + 0.5, e.yCoord + 0.5, e.zCoord + 0.5);
    }

    public Vector set(double dx, double dy, double dz)
    {
        x = dx;
        y = dy;
        z = dz;
        return this;
    }

    public Vector set(Vector vec)
    {
        x = vec.x;
        y = vec.y;
        z = vec.z;
        return this;
    }

    public double dotProduct(Vector vec)
    {
        double d = vec.x * x + vec.y * y + vec.z * z;
        
        if(d > 1 && d < 1.00001)
            d = 1;
        else if(d < -1 && d > -1.00001)
            d = -1;
        return d;
    }

    public double dotProduct(double dx, double dy, double dz)
    {
        return dx * x + dy * y + dz * z;
    }

    public Vector crossProduct(Vector vec)
    {
        double d = y * vec.z - z * vec.y;
        double d1 = z * vec.x - x * vec.z;
        double d2 = x * vec.y - y * vec.x;
        x = d;
        y = d1;
        z = d2;
        return this;
    }

    public Vector add(double dx, double dy, double dz)
    {
        x += dx;
        y += dy;
        z += dz;
        return this;
    }

    public Vector add(Vector vec)
    {
        x += vec.x;
        y += vec.y;
        z += vec.z;
        return this;
    }
    
    public Vector add(double d)
    {
        return add(d, d, d);
    }

    public Vector sub(Vector vec)
    {
        return subtract(vec);
    }
    
    public Vector subtract(Vector vec)
    {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }

    public Vector negate(Vector vec)
    {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }
    
    public Vector multiply(double dm)
    {
        x *= dm;
        y *= dm;
        z *= dm;
        return this;
    }

    public Vector multiply(Vector vec)
    {
        x *= vec.x;
        y *= vec.y;
        z *= vec.z;
        return this;
    }
    
    public Vector multiply(double fx, double fy, double fz)
    {
        x *= fx;
        y *= fy;
        z *= fz;
        return this;
    }

    public double mag()
    {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double magSquared()
    {
        return x * x + y * y + z * z;
    }

    public Vector normalize()
    {
        double d = mag();
        if(d != 0)
        {
            multiply(1 / d);
        }
        return this;
    }

    public String toString()
    {
        MathContext cont = new MathContext(4, RoundingMode.HALF_UP);
        return "Vector("+new BigDecimal(x, cont)+", "+new BigDecimal(y, cont)+", "+new BigDecimal(z, cont)+")";
    }
    
    public Vector perpendicular()
    {
        if(z == 0)
            return zCrossProduct();
        return xCrossProduct();
    }
    
    public Vector xCrossProduct()
    {
        double d = z;
        double d1 = -y;
        x = 0;
        y = d;
        z = d1;
        return this;
    }
    
    public Vector zCrossProduct()
    {
        double d = y;
        double d1 = -x;
        x = d;
        y = d1;
        z = 0;
        return this;
    }
    
    public Vector yCrossProduct()
    {
        double d = -z;
        double d1 = x;
        x = d;
        y = 0;
        z = d1;
        return this;
    }

    public double angle(Vector vec)
    {
        return Math.acos(copy().normalize().dotProduct(vec.copy().normalize()));
    }

    public boolean isZero()
    {
        return x == 0 && y == 0 && z == 0;
    }

    public boolean isAxial()
    {
        return x == 0 ? (y == 0 || z == 0) : (y == 0 && z == 0);
    }

    public double scalarProject(Vector b)
    {
        double l = b.mag();
        return l == 0 ? 0 : dotProduct(b)/l;
    }
    
    public Vector project(Vector b)
    {
        double l = b.magSquared();
        if(l == 0)
        {
            set(0, 0, 0);
            return this;
        }
        double m = dotProduct(b)/l;
        set(b).multiply(m);
        return this;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Vector))
            return false;
        Vector v = (Vector)o;
        return x == v.x && y == v.y && z == v.z;
    }
}