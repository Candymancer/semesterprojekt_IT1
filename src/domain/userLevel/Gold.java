/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.userLevel;

/**
 *
 * @author emilfrisk
 */
public class Gold implements UserLevel{
    double conversionRate = 2;

    @Override
    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public double getConversionRate() {
        return this.conversionRate;
    }
    
}
